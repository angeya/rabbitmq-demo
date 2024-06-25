package org.example.amqp.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: angeya
 * @date: 2024/6/24 16:22
 * @description:
 */
@Component
public class DirectReceive {

    @RabbitListener(queues = "direct.queue1")
    public void listenDirectQueue1(String msg) {
        System.out.println("消费者1接收到Direct消息：【" + msg + "】");
    }

    @RabbitListener(queues = "direct.queue2")
    public void listenDirectQueue2(String msg) {
        System.out.println("消费者2接收到Direct消息：【" + msg + "】");
    }
}
