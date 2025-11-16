package com.springcheerz.repositories

import com.springcheerz.models.ContentTaskStatus
import com.springcheerz.models.UpdateContentTaskEntity
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
class UpdateContentTaskRepository(private val entityManager: EntityManager) {
    @Transactional
    fun createUpdateContentTask(name: String): UpdateContentTaskEntity {
        val entity = UpdateContentTaskEntity(
            id = 0,
            name = name,
            status = ContentTaskStatus.IN_PROGRESS
        )
        entityManager.persist(entity)
        return entity
    }

    @Transactional
    fun markAsCompletedByName(taskName: String) {
        entityManager.createQuery(
            "UPDATE UpdateContentTaskEntity t SET t.status = :status WHERE t.name = :taskName"
        )
            .setParameter("status", ContentTaskStatus.COMPLETED)
            .setParameter("taskName", taskName)
            .executeUpdate()
    }
}

