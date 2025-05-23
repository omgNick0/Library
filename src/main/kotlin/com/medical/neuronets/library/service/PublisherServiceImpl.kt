package com.medical.neuronets.library.service

import com.medical.neuronets.library.dao.PublisherRepository
import com.medical.neuronets.library.mapper.PublisherMapper
import com.medical.neuronets.library.model.PublisherDto
import com.medical.neuronets.library.response.PublisherResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*



// добавили маппер
// разобраться с маппером

@Service
class PublisherServiceImpl(
    val publisherRepository: PublisherRepository,
    val publisherMapper: PublisherMapper
) : PublisherService {

    override fun create(publisherDto: PublisherDto): PublisherResponse {
        val publisherEntity = publisherMapper.toBean(publisherDto)
        publisherRepository.save(publisherEntity)

        return PublisherResponse(publisherEntity)
    }

    override fun getAll(): List<PublisherResponse> {
        return publisherRepository.findAll().map {
            PublisherResponse(it)
        }
    }

    override fun getById(id: UUID): PublisherResponse {
        return publisherRepository.findByIdOrNull(id)?.let { PublisherResponse(it) } ?: let {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }

    override fun delete(id: UUID) {
        publisherRepository.deleteById(id)
    }

    override fun put(id: UUID, publisherDto: PublisherDto): PublisherResponse {
        val publisherEntity =
            publisherRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
        publisherEntity.name = publisherDto.name

        publisherRepository.save(publisherEntity)
        return PublisherResponse(publisherEntity)
    }
}
