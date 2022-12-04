package com.example.seckill.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: RabbitMQ配置类
 * @author: chunyan.li
 * @time: 2022/8/19 19:42
 */
@Configuration
public class RabbitMQConfig {

//    @Bean
//    public Queue queue(){
//        return new Queue("queue",true);
//    }

}
