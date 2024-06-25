package org.example.amqp.simple;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: angeya
 * @date: 2024/6/26 0:27
 * @description:
 */
@SpringBootTest
class SimpleSendTest {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendSimpleMessage() {
        rabbitTemplate.convertAndSend("simple.queue", "hello, world!");
    }
}