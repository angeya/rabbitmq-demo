package org.example.amqp.simple;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author: angeya
 * @date: 2024/6/26 0:26
 * @description:
 */
@RabbitListener(queues = "simple.queue")
@Component
public class MultiTypeListener {

    @RabbitHandler
    public void listenStringMessage(String msg) {
        System.out.println("简单消费者接收到 String 消息：【" + msg + "】");
    }

    @RabbitHandler
    public void listenIntegerMessage(Integer msg) {
        System.out.println("简单消费者接收到 Integer 消息：【" + msg + "】");
    }

}
