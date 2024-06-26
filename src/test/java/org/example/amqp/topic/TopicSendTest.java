package org.example.amqp.topic;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: angeya
 * @date: 2024/6/24 17:11
 * @description:
 */
@SpringBootTest
class TopicSendTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testTopicExchange() {
        // 队列名称
        String exchangeName = "rabbit.topic";
        rabbitTemplate.convertAndSend(exchangeName, "nanjing.university", "南京大学");
        rabbitTemplate.convertAndSend(exchangeName, "nanjing.bridge", "南京大桥");
        rabbitTemplate.convertAndSend(exchangeName, "shanghai.university", "复旦大学");
    }

}