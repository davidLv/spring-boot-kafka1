package com.abin.lee.spring.boot.kafka.api.controller;

import com.abin.lee.spring.boot.kafka.api.producer.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by abin on 2018/3/16 16:40.
 * spring-boot-kafka1
 * com.abin.lee.spring.boot.kafka.api.controller
 */
@EnableScheduling
@Controller
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {

    @Autowired
    KafkaProducerService kafkaProducerService;

    @RequestMapping(value = "/send")
    @ResponseBody
    public String insert(String topicName, String jsonData) {
        String result = "FAILURE";
        try {
            this.kafkaProducerService.sendMessage(topicName, jsonData);
            result = "SUCCESS";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

//    @KafkaListener(id = "kafka-test-topic", topics = "kafka-test-topic")
//    public void listenT2(ConsumerRecord<?, ?> cr) throws Exception {
//        log.info("----------------------------before-------listenT2---------------------------------");
//        log.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
//        log.info("-----------------------------after-------listenT2---------------------------------");
//    }

    @Autowired
    private KafkaTemplate<?, String> kafkaTemplate;

    @Scheduled(fixedDelay = 5000)
    public void send() {
//        log.info("生产者 :{}",
//                "gaha_hero" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
//        kafkaTemplate.send("test-topic",
//                "gaha_hero" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));

        //send参数 1：topic,2:key,3:参数
        // 默认情况下，Kafka根据传递消息的key来进行分区的分配，即hash(key) % numPartitions,没有指定key就随机分配一个分区
    }




}
