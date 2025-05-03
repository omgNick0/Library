package com.medical.neuronets.library.dao

import com.medical.neuronets.library.entity.PublisherEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface PublisherRepository: JpaRepository<PublisherEntity, UUID>


