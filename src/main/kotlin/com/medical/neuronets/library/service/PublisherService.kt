package com.medical.neuronets.library.service

import com.medical.neuronets.library.model.PublisherDto
import com.medical.neuronets.library.response.PublisherResponse

import java.util.UUID


interface PublisherService {
    fun create(publisherDto: PublisherDto): PublisherResponse
    fun delete(id: UUID)
    fun put(id: UUID, publisherDto: PublisherDto): PublisherResponse
    fun getAll(): List<PublisherResponse>
    fun getById(id: UUID): PublisherResponse
}