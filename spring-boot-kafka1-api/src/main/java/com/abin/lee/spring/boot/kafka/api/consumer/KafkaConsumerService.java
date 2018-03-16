package com.abin.lee.spring.boot.kafka.api.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created by abin on 2018/3/16 16:15.
 * spring-boot-kafka1
 * com.abin.lee.spring.boot.kafka.api.consumer
 */
@Slf4j
@Component
public class KafkaConsumerService {

    @KafkaListener(topics = {"kafka-test-topic"})
    public void processMessage(String content){
        System.out.println("--------------------------------------------");
        System.out.println("----content : " + content);
        System.out.println("--------------------------------------------");
    }


    @KafkaListener(topics = {"kafka-test-topic"})
    public void processKafkaMessage(ConsumerRecord<?, ?> consumerRecord){
        System.out.println("--------------------before----processKafkaMessage------------------------");
        log.info("{} - {} : {}", consumerRecord.topic(), consumerRecord.key(), consumerRecord.value());
        System.out.println("--------------------after------processKafkaMessage------------------------");
    }




}
