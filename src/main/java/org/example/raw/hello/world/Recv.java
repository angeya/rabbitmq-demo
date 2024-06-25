package org.example.raw.hello.world;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.nio.charset.StandardCharsets;

public class Recv {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        // 1，设置连接参数
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("121.4.16.5");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("test");
        factory.setPassword("test");

        // 创建连接
        Connection connection = factory.newConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" 正在监听消息... 结束请按 CTRL+C");

        // 声明消息接收回调
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" 接收到消息 【" + message + "】");
        };
        // 监听消息
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }
}
