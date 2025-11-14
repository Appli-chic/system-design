package com.springcheerz.rabbitmq

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ContentReceiver {
    @RabbitListener(queues = ["content-queue"])
    fun receive(message: String) {
        println(" [x] Received '$message'")
    }
}