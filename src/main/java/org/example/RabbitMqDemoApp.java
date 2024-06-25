package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: angeya
 * @date: 2024/6/24 16:29
 * @description:
 */
@SpringBootApplication
public class RabbitMqDemoApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication();
        app.run(args);
    }
}
