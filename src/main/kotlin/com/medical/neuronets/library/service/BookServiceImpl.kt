package com.medical.neuronets.library.service

import com.medical.neuronets.library.dao.BookRepository
import com.medical.neuronets.library.dao.PublisherRepository
import com.medical.neuronets.library.entity.BookEntity
import com.medical.neuronets.library.model.BookDto
import com.medical.neuronets.library.response.BookResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*


@Service
class BookServiceImpl(val bookRepository: BookRepository, val publisherRepository: PublisherRepository): BookService {
    override fun getAll(): List<BookResponse> {
        return bookRepository.findAll().map {
            BookResponse(it)
        }
    }

    override fun getById(id: UUID): BookResponse {
        return bookRepository.findByIdOrNull(id)?.let { BookResponse(it) } ?: let {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

    override fun create(bookDto: BookDto): BookResponse {
        val bookEntity = BookEntity()
        bookEntity.title = bookDto.title
        bookEntity.author = bookDto.author
        bookEntity.year = bookDto.year
        bookEntity.publisher = publisherRepository.findByIdOrNull(bookDto.publisherId)
        bookEntity.pageCount = bookDto.pageCount
        bookRepository.save(bookEntity)
        return BookResponse(bookEntity)
    }

    override fun delete(id: UUID) {
        bookRepository.deleteById(id)
    }

    override fun put(id: UUID, bookDto: BookDto): BookResponse {
        val bookEntity =
            bookRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
        bookEntity.title = bookDto.title
        bookEntity.author = bookDto.author
        bookEntity.year = bookDto.year
        bookEntity.publisher = publisherRepository.findByIdOrNull(bookDto.publisherId)
        bookEntity.pageCount = bookDto.pageCount
        bookRepository.save(bookEntity)
        return BookResponse(bookEntity)
    }

}