package com.medical.neuronets.library.service

import com.medical.neuronets.library.model.TookBookDto
import com.medical.neuronets.library.response.TookBookResponse
import org.springframework.stereotype.Service
import java.util.UUID

interface TookBookService {
    fun create(tookBookDto: TookBookDto): TookBookResponse
    fun delete(id: UUID)
    fun put(id: UUID, tookBookDto: TookBookDto): TookBookResponse
    fun getAll(): List<TookBookResponse>
    fun getById(id: UUID): TookBookResponse
}