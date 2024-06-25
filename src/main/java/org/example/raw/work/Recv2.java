package org.example.raw.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.nio.charset.StandardCharsets;

public class Recv2 {

    private final static String QUEUE_NAME = "durable";

    public static void main(String[] argv) throws Exception {
        // 1，设置连接参数
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("121.4.16.58");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("test");
        factory.setPassword("test");

        // 创建连接
        Connection connection = factory.newConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        channel.basicQos(0, 1, false);
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println(" 正在监听消息... 结束请按 CTRL+C");

        // 声明消息接收回调
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            long tag = delivery.getEnvelope().getDeliveryTag();
            System.out.println(tag + "消费者2 接收到消息 【" + message + "】");
            channel.basicAck(tag, false);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        // 监听消息
        channel.basicConsume(QUEUE_NAME, false, deliverCallback, consumerTag -> {});
    }
}
