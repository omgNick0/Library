package com.medical.neuronets.library.service

import com.medical.neuronets.library.model.UserDto
import com.medical.neuronets.library.response.UserResponse
import java.util.UUID


interface UserService {
    fun create(userDto: UserDto): UserResponse
    fun delete(id: UUID)
    fun put(id: UUID, userDto: UserDto): UserResponse
    fun getAll(): List<UserResponse>
    fun getById(id: UUID): UserResponse
}