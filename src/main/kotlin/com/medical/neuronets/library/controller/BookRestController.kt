package com.medical.neuronets.library.controller

import com.medical.neuronets.library.model.BookDto
import com.medical.neuronets.library.response.BookResponse
import com.medical.neuronets.library.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.UUID


@RestController
@RequestMapping("/books")
class BookRestController(val bookService: BookService) {

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: UUID): BookResponse {
        return bookService.getById(id)
    }

    @GetMapping
    fun getAllBooks() = bookService.getAll()

    @PostMapping()
    fun addBook(@RequestBody bookDto: BookDto): BookResponse {
        return bookService.create(bookDto)
    }
    @PutMapping("/{id}")
    fun putPublisher(@RequestBody bookDto: BookDto, @PathVariable id: UUID): BookResponse {
        return bookService.put(id, bookDto)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable id: UUID) {
        bookService.delete(id)
    }
}
