package com.example

import io.github.damir.denis.tudor.ktor.server.rabbitmq.RabbitMQ
import io.github.damir.denis.tudor.ktor.server.rabbitmq.dsl.basicConsume
import io.github.damir.denis.tudor.ktor.server.rabbitmq.dsl.rabbitmq
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureRabbitMQ()
    configureRouting()
}

private fun Application.configureRabbitMQ() {
    install(RabbitMQ) {
        uri = "amqp://guest:guest@localhost:5672"
        defaultConnectionName = "default_connection"
        connectionAttempts = 20
        attemptDelay = 10
        dispatcherThreadPollSize = 4
        tlsEnabled = false
    }

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
