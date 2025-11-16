package com.example

import com.example.model.UpdateContentTaskTable
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    fun init(environment: ApplicationEnvironment) {
        val databaseUrl = environment.config.property("database.url").getString()
        val databaseDriver = environment.config.property("database.driver").getString()
        val databaseUser = environment.config.property("database.user").getString()
        val databasePassword = environment.config.property("database.password").getString()

        Database.connect(
            url = databaseUrl,
            driver = databaseDriver,
            user = databaseUser,
            password = databasePassword
        )

        transaction {
             SchemaUtils.create(UpdateContentTaskTable)
        }
    }
}