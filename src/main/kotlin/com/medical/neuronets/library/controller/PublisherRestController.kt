package com.medical.neuronets.library.controller

import com.medical.neuronets.library.model.PublisherDto
import com.medical.neuronets.library.response.PublisherResponse
import com.medical.neuronets.library.service.PublisherService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/publishers")
class PublisherRestController(val publisherService: PublisherService) {

    @GetMapping("{id}")
    fun getById(@PathVariable id: UUID): PublisherResponse {
        return publisherService.getById(id)
    }

    @GetMapping
    fun getAll() = publisherService.getAll()

    @PostMapping
    fun addPublisher(@RequestBody publisherDto: PublisherDto): PublisherResponse {
        return publisherService.create(publisherDto)
    }

    @PutMapping("/{id}")
    fun putPublisher(@RequestBody publisherDto: PublisherDto, @PathVariable id: UUID): PublisherResponse {
        return publisherService.put(id, publisherDto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletePublisher(@PathVariable id: UUID) {
        publisherService.delete(id)
    }
}
