package com.springcheerz.rabbitmq

import com.springcheerz.repositories.UpdateContentTaskRepository
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ContentSender(
    private val updateContentTaskRepository: UpdateContentTaskRepository,
    private val template: RabbitTemplate,
    private val queue: Queue,
) {
    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    fun send() {
        val contentName = UUID.randomUUID().toString()
        updateContentTaskRepository.createUpdateContentTask(contentName)
        this.template.convertAndSend(queue.name, contentName)
        println(" [x] Sent '$contentName'")
    }
}
