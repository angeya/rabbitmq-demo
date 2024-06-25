package org.example.amqp.direct;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author: angeya
 * @date: 2024/6/24 16:46
 * @description:
 */
@SpringBootTest
class DirectSendTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testFanoutExchange() {
        // 队列名称
        String exchangeName = "rabbit.direct";

        rabbitTemplate.convertAndSend(exchangeName, "dingTalk", "钉钉消息1");
        rabbitTemplate.convertAndSend(exchangeName, "dingTalk", "钉钉消息2");
        rabbitTemplate.convertAndSend(exchangeName, "dingTalk", "钉钉消息3");
        rabbitTemplate.convertAndSend(exchangeName, "wxWork", "企业微信消息");
    }
}