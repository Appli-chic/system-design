package com.springcheerz.models

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

enum class ContentTaskStatus {
    IN_PROGRESS,
    COMPLETED,
    FAILED,
}

@Entity
@Table(name = "update_content_task")
data class UpdateContentTaskEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long,

    private val name: String,

    @Enumerated(EnumType.STRING)
    private val status: ContentTaskStatus,
)
