package org.example.amqp.simple;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author: angeya
 * @date: 2024/6/26 0:26
 * @description:
 */
@Component
public class SimpleListener {

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg) {
        System.out.println("简单消费者接收到消息：【" + msg + "】");
    }

}
