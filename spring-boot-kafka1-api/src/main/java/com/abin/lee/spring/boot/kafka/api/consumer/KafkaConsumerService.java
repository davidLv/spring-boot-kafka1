package com.abin.lee.spring.boot.kafka.api.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * Created by abin on 2018/3/16 16:15.
 * spring-boot-kafka1
 * com.abin.lee.spring.boot.kafka.api.consumer
 */
@Slf4j
@Component
public class KafkaConsumerService {

    @KafkaListener(topicPartitions={@TopicPartition(partitions={"0","1"},topic="kafka-test-topic")}, group = "someGroup")
    public void processSomeMessage(ConsumerRecord<?, ?> consumerRecord){
        System.out.println("--------------------before----processSomeMessage------------------------");
        log.info("{} - {} : {}", consumerRecord.topic(), consumerRecord.key(), consumerRecord.value());
        System.out.println("--------------------after------processSomeMessage------------------------");
    }


    @KafkaListener(topics = {"kafka-test-topic"}, group = "KafkaGroup")
    public void processKafkaMessage(ConsumerRecord<?, ?> consumerRecord){
        System.out.println("--------------------before----processKafkaMessage------------------------");
        log.info("{} - {} : {}", consumerRecord.topic(), consumerRecord.key(), consumerRecord.value());
        System.out.println("--------------------after------processKafkaMessage------------------------");
//        consumerRecord.partition();
    }




}
