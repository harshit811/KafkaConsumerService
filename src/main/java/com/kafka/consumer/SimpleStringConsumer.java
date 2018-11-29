package com.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class SimpleStringConsumer extends SpringBootServletInitializer{

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "mygroup");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");

        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("mytopic"));

        boolean running = true;
        System.out.println("consumer--------------------------------------------------------===========================================-----------------------------------------------------------------------------------------");
		
        while (running) {
            ConsumerRecords<String, byte[]> records = consumer.poll(100);
            for (ConsumerRecord<String, byte[]> record : records) {
            	
    
            	String sds =new String(record.value());
            	
            	System.out.printf("key = %s, value = %s%n", record.key(),new String(record.value()));
            	
            	/*System.out.println( "key = %s value = %s%n",
                         record.key(),
                         UserAvroSerdes.deserialize(record.value()).getName().toString());*/
            	 
            }
        }

        consumer.close();
    }
    
    
    /**
	 * Used when run as WAR
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	    return builder.sources(SimpleStringConsumer.class);
	}
	
	
    
    /*private static <V> V deserialize(final byte[] objectData) {
        return (V) org.apache.commons.lang3.SerializationUtils.deserialize(objectData);
    }*/
}

//package com.kafka.consumer;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
//
//
//@SpringBootApplication
//@ComponentScan(basePackages = { "com.kafka.consumer" })
//@EnableAspectJAutoProxy(proxyTargetClass = true)
//public class SimpleStringConsumer {
//	public static void main(String[] args) {
//		SpringApplication.run(SimpleStringConsumer.class, args);
//	}
//}












//
//@SpringBootApplication
//public class SimpleStringConsumer {
//
//	@Autowired
//	private SparkSession sparkSession;
//	
//    public static void main(String[] args) {
//    	 
//    	/* SparkConf conf = new SparkConf()
//                 .setAppName("kafka-sandbox")
//                 .setMaster("local[*]");*/
//    
//    	StreamingContext ssc = new StreamingContext(sparkSession.ge., new Duration(2000));
//    	 
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "localhost:9092");
//        props.put("group.id", "mygroup");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(Arrays.asList("mytopic"));
//
//        boolean running = true;
//        while (running) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records) {
//                System.out.println(record.value());
//            }
//        }
//
//        consumer.close();
//    }
//}





