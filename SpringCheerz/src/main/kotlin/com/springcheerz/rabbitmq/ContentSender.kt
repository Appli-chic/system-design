package com.springcheerz.rabbitmq

import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ContentSender(
    private val template: RabbitTemplate,
    private val queue: Queue,
) {
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    fun send() {
        val message = UUID.randomUUID().toString()
        this.template.convertAndSend(queue.name, message)
        println(" [x] Sent '$message'")
    }
}
