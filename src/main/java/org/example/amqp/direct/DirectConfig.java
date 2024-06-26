package org.example.amqp.direct;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: angeya
 * @date: 2024/6/24 16:35
 * @description:
 */
@Configuration
public class DirectConfig {

    /**
     * 声明交换机
     * @return Direct交换机
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("rabbit.direct");
    }

    /**
     * 队列1
     */
    @Bean
    public Queue directQueue1() {
        return new Queue("direct.queue1");
    }

    /**
     * 绑定交换机和队列
     * @return 绑定关系
     */
    @Bean
    public Binding directBindingQueue1(DirectExchange exchange, Queue directQueue1) {
        return BindingBuilder.bind(directQueue1).to(exchange).with("dingTalk");
    }

    /**
     * 队列2
     */
    @Bean
    public Queue directQueue2() {
        return new Queue("direct.queue2");
    }

    /**
     * 绑定交换机和队列
     * @return 绑定关系
     */
    @Bean
    public Binding directBindingQueue2(DirectExchange exchange, Queue directQueue2) {
        return BindingBuilder.bind(directQueue2).to(exchange).with("wxWork");
    }
}
