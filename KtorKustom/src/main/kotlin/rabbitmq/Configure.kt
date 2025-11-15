package com.example.rabbitmq

import io.github.damir.denis.tudor.ktor.server.rabbitmq.RabbitMQ
import io.ktor.server.application.Application
import io.ktor.server.application.install

internal fun Application.configureRabbitMQ() {
    val uri = environment.config.property("rabbitmq.uri").getString()
    val connectionName = environment.config.property("rabbitmq.connection.name").getString()
    val connectionAttempts = environment.config.property("rabbitmq.connection.attempts").getString().toInt()
    val attemptDelay = environment.config.property("rabbitmq.connection.attemptDelay").getString().toInt()
    val threadPoolSize = environment.config.property("rabbitmq.dispatcher.threadPoolSize").getString().toInt()
    val tlsEnabled = environment.config.property("rabbitmq.tls.enabled").getString().toBoolean()

    install(RabbitMQ) {
        this.uri = uri
        this.defaultConnectionName = connectionName
        this.connectionAttempts = connectionAttempts
        this.attemptDelay = attemptDelay
        this.dispatcherThreadPollSize = threadPoolSize
        this.tlsEnabled = tlsEnabled
    }

    consumeContentQueue()
}
