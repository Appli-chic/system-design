package com.example.model

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.timestamp

enum class TaskStatus {
    PENDING,
    COMPLETED,
    FAILED
}

object UpdateContentTaskTable: IntIdTable("UpdateContentTask") {
    val name = varchar("name", 255)
    val status = enumerationByName<TaskStatus>("status", 50)
    val createdAt = timestamp("created_at")
    val updatedAt = timestamp("updated_at")
}
