package com.medical.neuronets.library.controller

import com.medical.neuronets.library.model.UserDto
import com.medical.neuronets.library.response.UserResponse
import com.medical.neuronets.library.service.UserService
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


// 2 контроллер
// дальше - секьюрити


@RestController
@RequestMapping("/users")
class UserRestController(val userService: UserService) {
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: UUID): UserResponse {
        return userService.getById(id)
    }

    @GetMapping
    fun getAllUsers() = userService.getAll()

    @PostMapping()
    fun addUser(@RequestBody userDto: UserDto): UserResponse {
        return userService.create(userDto)
    }
    @PutMapping("/{id}")
    fun putUser(@RequestBody userDto: UserDto, @PathVariable id: UUID): UserResponse {
        return userService.put(id, userDto)
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: UUID) {
        userService.delete(id)
    }
}