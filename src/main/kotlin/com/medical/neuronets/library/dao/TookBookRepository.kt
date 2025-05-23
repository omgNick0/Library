package com.medical.neuronets.library.dao

import com.medical.neuronets.library.entity.TookBookEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TookBookRepository: JpaRepository<TookBookEntity, UUID> {

}