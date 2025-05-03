package com.medical.neuronets.library.service

import com.medical.neuronets.library.dao.BookRepository
import com.medical.neuronets.library.dao.TookBookRepository
//import com.medical.neuronets.library.dao.UserRepository
import com.medical.neuronets.library.entity.TookBookEntity
import com.medical.neuronets.library.model.TookBookDto
import com.medical.neuronets.library.response.TookBookResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

// val userRepository: UserRepository

@Service
class TookBookImpl(val tookBookRepository: TookBookRepository,
                   val bookRepository: BookRepository): TookBookService {
    override fun create(tookBookDto: TookBookDto): TookBookResponse {
        val tookBookEntity = TookBookEntity()
        tookBookEntity.book = bookRepository.findByIdOrNull(tookBookDto.bookID)
     //   tookBookEntity.user = userRepository.findByIdOrNull(tookBookDto.userID)
        tookBookEntity.tookDate = tookBookDto.tookDate
        tookBookEntity.returnDate = tookBookDto.returnDate
     //   bookRepository.deleteById()

        tookBookRepository.save(tookBookEntity)
        return TookBookResponse(tookBookEntity)
    }

    override fun delete(id: UUID) {
        tookBookRepository.deleteById(id)
    }

    override fun put(
        id: UUID,
        tookBookDto: TookBookDto
    ): TookBookResponse {
        val tookBookEntity =
            tookBookRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
        tookBookEntity.book = bookRepository.findByIdOrNull(tookBookDto.bookID)
 //       tookBookEntity.user = userRepository.findByIdOrNull(tookBookDto.bookID)
        tookBookEntity.tookDate = tookBookDto.tookDate
        tookBookEntity.returnDate = tookBookDto.returnDate
        tookBookRepository.save(tookBookEntity)
        return TookBookResponse(tookBookEntity)
    }

    override fun getAll(): List<TookBookResponse> {
        return tookBookRepository.findAll().map { TookBookResponse(it) }
    }

    override fun getById(id: UUID): TookBookResponse {
        return tookBookRepository.findByIdOrNull(id)?.let { TookBookResponse(it) } ?: let {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }
}