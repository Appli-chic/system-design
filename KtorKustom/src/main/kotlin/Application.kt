package com.example

import com.example.rabbitmq.configureRabbitMQ
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureRabbitMQ()
    configureRouting()
}

