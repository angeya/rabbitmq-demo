package org.example.amqp.work;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: angeya
 * @date: 2024/6/26 1:14
 * @description:
 */
@SpringBootTest
class WorkQueueSendTest {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendSimpleMessage() throws Throwable {
        for (int i = 0; i < 20; i++) {
            // 发送消息
            rabbitTemplate.convertAndSend("work.queue", "hello msg - " + i);
            Thread.sleep(20);
        }
    }
}