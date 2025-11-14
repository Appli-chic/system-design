package com.springcheerz

import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@EnableRabbit
@SpringBootApplication
class SpringCheerzApplication

fun main(args: Array<String>) {
    runApplication<SpringCheerzApplication>(*args)
}
