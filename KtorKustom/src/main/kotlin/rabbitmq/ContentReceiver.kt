package com.example.rabbitmq

import com.example.repository.UpdateContentTaskRepository
import io.github.damir.denis.tudor.ktor.server.rabbitmq.dsl.basicConsume
import io.github.damir.denis.tudor.ktor.server.rabbitmq.dsl.rabbitmq
import io.ktor.server.application.Application

internal fun Application.consumeContentQueue() {
    val updateContentTaskRepository = UpdateContentTaskRepository()

    rabbitmq {
        basicConsume {
            autoAck = true
            queue = "content-queue"
            deliverCallback<String> { message ->
                println("Received message: ${message.body}")
                val updateContentTaskId = updateContentTaskRepository.createUpdateContentTask(message.body)
                println("UpdateContentTask created: ${message.body}")
                updateContentTaskRepository.markAsCompleted(updateContentTaskId)
                println("UpdateContentTask updated: ${message.body}")
            }
        }
    }
}
