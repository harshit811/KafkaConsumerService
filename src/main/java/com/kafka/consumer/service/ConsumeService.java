//package com.kafka.consumer.service;
//
//import java.util.Arrays;
//import java.util.Properties;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.spark.sql.SparkSession;
//import org.apache.spark.streaming.Duration;
//import org.apache.spark.streaming.StreamingContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ConsumeService {
//	
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
//    	//StreamingContext ssc = new StreamingContext(sparkSession., new Duration(2000));
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
//
//
//
//
//
///*package com.kafka.consumer;
//
//import java.util.Arrays;
//import java.util.Properties;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class SimpleStringConsumer {
//
//    public static void main(String[] args) {
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
//}*/
//
//}
