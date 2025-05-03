package com.medical.neuronets.library.dao

import com.medical.neuronets.library.entity.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BookRepository: JpaRepository<BookEntity, UUID> {
}