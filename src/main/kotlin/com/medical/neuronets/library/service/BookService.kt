package com.medical.neuronets.library.service

import com.medical.neuronets.library.model.BookDto
import com.medical.neuronets.library.response.BookResponse
import com.medical.neuronets.library.response.PublisherResponse
import java.util.UUID

interface BookService {
    fun create(bookDto: BookDto): BookResponse
    fun delete(id: UUID)
    fun put(id: UUID, bookDto: BookDto): BookResponse
    fun getAll(): List<BookResponse>
    fun getById(id: UUID): BookResponse
}