package com.example.rabbitmq

import io.github.damir.denis.tudor.ktor.server.rabbitmq.dsl.basicConsume
import io.github.damir.denis.tudor.ktor.server.rabbitmq.dsl.rabbitmq
import io.ktor.server.application.Application

internal fun Application.consumeContentQueue() {
    rabbitmq {
        basicConsume {
            autoAck = true
            queue = "content-queue"
            deliverCallback<String> { message ->
                println("Received message: $message")
            }
        }
    }
}
