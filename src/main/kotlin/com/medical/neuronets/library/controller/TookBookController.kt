package com.medical.neuronets.library.controller

import com.medical.neuronets.library.model.TookBookDto
import com.medical.neuronets.library.response.TookBookResponse
import com.medical.neuronets.library.service.TookBookService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID


@RestController
@RequestMapping("/tookBooks")
class TookBookController(val tookBookService: TookBookService) {
    @GetMapping("/{id}")
    fun getTookBookById(@PathVariable id: UUID): TookBookResponse {
        return tookBookService.getById(id)
    }

    @GetMapping
    fun getAllTookBooks() = tookBookService.getAll()

    @PostMapping()
    fun addTookBook(@RequestBody tookBookDto: TookBookDto): TookBookResponse {
        return tookBookService.create(tookBookDto)
    }
    @PutMapping("/{id}")
    fun putTookBook(@RequestBody tookBookDto: TookBookDto, @PathVariable id: UUID): TookBookResponse {
        return tookBookService.put(id, tookBookDto)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteTookBook(@PathVariable id: UUID) {
        tookBookService.delete(id)
    }
}