package org.example.amqp.topic;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: angeya
 * @date: 2024/6/24 16:35
 * @description:
 */
//@Configuration
public class TopicConfig {

    /**
     * 声明交换机
     * @return Topic交换机
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("rabbit.topic");
    }

    /**
     * 队列1
     */
    @Bean
    public Queue topicQueue1() {
        return new Queue("topic.queue1");
    }

    ///**
    // * 绑定交换机和队列
    // * @return 绑定关系
    // */
    //@Bean
    //public Binding topicBindingQueue1(TopicExchange exchange, Queue topicQueue1) {
    //    return BindingBuilder.bind(topicQueue1).to(exchange).with("dingTalk");
    //}

    /**
     * 队列2
     */
    @Bean
    public Queue topicQueue2() {
        return new Queue("topic.queue2");
    }

    ///**
    // * 绑定交换机和队列
    // * @return 绑定关系
    // */
    //@Bean
    //public Binding topicBindingQueue2(TopicExchange exchange, Queue topicQueue2) {
    //    return BindingBuilder.bind(topicQueue2).to(exchange).with("wxWork");
    //}
}
