//package com.kafka.consumer.config;
//
//import org.apache.spark.SparkConf;
//import org.apache.spark.SparkContext;
//import org.apache.spark.sql.SparkSession;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
//
//@Configuration
//@PropertySource("classpath:application.properties")
//public class ConsumerSparkConfig {
//
//	@Value("${app.name}")
//	private String appName;
//
//	@Value("${master.uri}")
//	private String masterUri;
//
//
//	@Bean
//	public SparkConf sparkConf() {
//		SparkConf sparkConf = new SparkConf().setAppName(appName).setMaster(masterUri);
//		return sparkConf;
//	}
//	
//
//	@Bean
//	public SparkContext sparkContext() {
//		SparkContext sparkContext = new SparkContext(sparkConf());
//		return sparkContext;
//	}
//	
//
//	@Bean
//	public SparkSession sparkSession() {
//		return SparkSession.builder().appName("Java Spark SQL basic example")
//				//.config("spark.cassandra.connection.host", cassandraHost)
//				//.config("spark.cassandra.connection.port", cassandraPort)
//				//.config("spark.cassandra.auth.username", cassandraUserName)
//				//.config("spark.cassandra.auth.password", cassandraPassword)
//				// .config("spark.sql.session.timeZone", sparkTimezone)
//				//.config("spark.sql.session.timeZone", "UTC").master("local[2]").getOrCreate();
//				.master("local[2]").getOrCreate();
//	}
//
//	@Bean
//	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
//
//}