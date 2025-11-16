package com.example.repository

import com.example.model.TaskStatus
import com.example.model.UpdateContentTaskTable
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import java.time.Instant

class UpdateContentTaskRepository {
    fun createUpdateContentTask(name: String): Int {
        return transaction {
            UpdateContentTaskTable.insert {
                it[UpdateContentTaskTable.name] = name
                it[status] = TaskStatus.PENDING
                it[createdAt] = Instant.now()
                it[updatedAt] = Instant.now()
            } get UpdateContentTaskTable.id
        }.value
    }

    fun markAsCompleted(taskId: Int) {
        transaction {
            UpdateContentTaskTable.update({ UpdateContentTaskTable.id eq taskId }) {
                it[status] = TaskStatus.COMPLETED
                it[updatedAt] = Instant.now()
            }
        }
    }
}