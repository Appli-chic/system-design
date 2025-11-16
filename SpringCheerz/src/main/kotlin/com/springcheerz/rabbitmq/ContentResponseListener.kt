package com.springcheerz.rabbitmq

import com.springcheerz.repositories.UpdateContentTaskRepository
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class ContentResponseListener(private val updateContentTaskRepository: UpdateContentTaskRepository) {

    @RabbitListener(queues = ["content-processed-queue"])
    fun handleResponse(message: String) {
        println("Received response from Ktor: $message")
        updateContentTaskRepository.markAsCompletedByName(message)
        println("Marked task as completed: $message")
    }
}