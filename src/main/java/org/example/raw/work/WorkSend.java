package org.example.raw.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;
import java.util.Date;

public class WorkSend {

    private final static String QUEUE_NAME = "transient";

    public static void main(String[] argv) throws Exception {
        // 1，设置连接参数
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("121.4.16.58");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("test");
        factory.setPassword("test");

        // 2，创建连接
        try (Connection connection = factory.newConnection();
             // 3，创建通道
            Channel channel = connection.createChannel()) {
            // 4，声明队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World! " + new Date();

            for (int i = 0; i < 10; i++) {
                // 5，发送消息
                channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
                System.out.println(" 发送消息：【" + message + "】");
                Thread.sleep(100);
            }

        }
    }
}
