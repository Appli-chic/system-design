package com.springcheerz.rabbitmq

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {
    @Bean
    fun contentQueue(): Queue = Queue("content-queue", true)

    @Bean
    fun responseQueue(): Queue {
        return Queue("content-processed-queue", true) // durable queue
    }
}