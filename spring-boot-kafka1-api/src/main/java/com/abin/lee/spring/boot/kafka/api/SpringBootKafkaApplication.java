package com.abin.lee.spring.boot.kafka.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by abin on 2018/3/16 14:51.
 * spring-boot-kafka1
 * com.abin.lee.spring.boot.kafka.api
 */
@ComponentScan(value = {"com.abin.lee.spring.boot.kafka.api"})

@SpringBootApplication
public class SpringBootKafkaApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(SpringBootKafkaApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootKafkaApplication.class, args);
    }


}