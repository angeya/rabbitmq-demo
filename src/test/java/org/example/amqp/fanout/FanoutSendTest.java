package org.example.amqp.fanout;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: angeya
 * @date: 2024/6/24 16:25
 * @description:
 */
@SpringBootTest
class FanoutSendTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testFanoutExchange() {
        // 队列名称
        String exchangeName = "rabbit.fanout";
        // 消息
        String message = "hello world!";
        rabbitTemplate.convertAndSend(exchangeName, "", message);
    }
}