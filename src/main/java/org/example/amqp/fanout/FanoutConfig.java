package org.example.amqp.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: angeya
 * @date: 2024/6/24 16:13
 * @description:
 */
@Configuration
public class FanoutConfig {

    /**
     * 声明交换机
     * @return Fanout交换机
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("rabbit.fanout");
    }

    /**
     * 队列1
     */
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout.queue1");
    }

    /**
     * 绑定交换机和队列
     * @return 绑定关系
     */
    @Bean
    public Binding fanoutBindingQueue1(FanoutExchange fanoutExchange, Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    /**
     * 队列2
     */
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout.queue2");
    }

    /**
     * 绑定交换机和队列
     * @return 绑定关系
     */
    @Bean
    public Binding fanoutBindingQueue2(FanoutExchange fanoutExchange, Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

}
