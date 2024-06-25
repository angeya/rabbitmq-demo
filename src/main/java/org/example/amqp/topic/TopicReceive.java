package org.example.amqp.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: angeya
 * @date: 2024/6/24 16:22
 * @description:
 */
@Component
public class TopicReceive {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(value = "rabbit.topic", type = ExchangeTypes.TOPIC),
            key = "nanjing.#"
    ))
    public void listenTopicQueue1(String msg) {
        System.out.println("消费者1接收到Topic消息：【" + msg + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(value = "rabbit.topic", type = ExchangeTypes.TOPIC),
            key = "#.university"
    ))
    public void listenTopicQueue2(String msg) {
        System.out.println("消费者2接收到Topic消息：【" + msg + "】");
    }
}
