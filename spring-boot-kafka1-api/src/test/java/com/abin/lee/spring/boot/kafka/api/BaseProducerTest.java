package com.abin.lee.spring.boot.kafka.api;

import com.abin.lee.spring.boot.kafka.api.producer.KafkaProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 描述: 测试 kafka
 *
 * @author yanpenglei
 * @create 2017-10-16 18:45
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootKafkaApplication.class)
public class BaseProducerTest {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Test
    public void test() throws Exception {

        kafkaProducerService.sendMessage("kafka-test-topic", "topic--------1");
        kafkaProducerService.sendMessage("kafka-test-topic", "topic--------2");
    }
}
