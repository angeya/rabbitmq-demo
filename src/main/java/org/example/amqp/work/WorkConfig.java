package org.example.amqp.work;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: angeya
 * @date: 2024/6/26 0:33
 * @description:
 */
@Configuration
public class WorkConfig {

    /**
     * 声明队列
     * @return 消息队列
     */
    @Bean
    public Queue workQueue() {
        return new Queue("work.queue");
    }
}
