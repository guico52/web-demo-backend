package com.guico.webdemo.web.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import java.util.Properties;

public class Test {
    public static void main(String[] args) {
//        创建Props
        Properties props = new Properties();
//        为kafka配置
        props.put("bootstrap.servers","guico.top:9092");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        Producer<String,String> producer = new KafkaProducer<String, String>(props);
        for (int i = 0; i < 10; i++) {
            producer.send(new org.apache.kafka.clients.producer.ProducerRecord<String, String>("test",Integer.toString(i),Integer.toString(i)));
        }
        producer.close();
    }
}
