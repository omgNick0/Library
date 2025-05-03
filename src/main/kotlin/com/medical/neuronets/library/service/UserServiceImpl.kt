package com.medical.neuronets.library.service;

import com.medical.neuronets.library.dao.UserRepository
import com.medical.neuronets.library.entity.UserEntity
import com.medical.neuronets.library.model.UserDto
import com.medical.neuronets.library.response.UserResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@Service
class UserServiceImpl(val userRepository: UserRepository) : UserService {
    override fun create(userDto: UserDto): UserResponse {
        val userEntity = UserEntity()
        userEntity.name = userDto.name
        userRepository.save(userEntity)
        return UserResponse(userEntity)
    }

    override fun delete(id: UUID) {
        userRepository.deleteById(id)
    }

    override fun put(
        id: UUID,
        userDto: UserDto
    ): UserResponse {
        val userEntity =
            userRepository.findById(id).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
        userEntity.name = userDto.name
        userRepository.save(userEntity)
        return UserResponse(userEntity)
    }

    override fun getAll(): List<UserResponse> {
        return userRepository.findAll().map { UserResponse(it) }
    }

    override fun getById(id: UUID): UserResponse {
        return userRepository.findByIdOrNull(id)?.let { UserResponse(it) } ?: let {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
    }
}
