package org.example.amqp.simple;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: angeya
 * @date: 2024/6/27 0:58
 * @description:
 */
//@Component
public class ManualAckListener {

    @RabbitListener(queues = "simple.queue", ackMode = "MANUAL")
    public void listenSimpleQueueMessage(String message, Channel channel, Message amqpMessage) throws Exception{
        try {
            System.out.println("简单消费者接收到消息：【" + message + "】");
             //int a = 1/0;

            // 手动确认消息 multiple:false 只确认当前消息，如果不确认，相当于没有被消费
            channel.basicAck(amqpMessage.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            System.err.println("异常了，不确认消息");
            // 如果处理消息时出现异常，可以选择不确认消息，requeue true还是false都会unack然后重新入队 保证可靠性
            channel.basicNack(amqpMessage.getMessageProperties().getDeliveryTag(), false, true);
            // 拒绝消息 和确认的区别是可以选择重新入队
            //channel.basicReject(amqpMessage.getMessageProperties().getDeliveryTag(),  false);
            System.exit(0);
        }
    }
}