package com.medical.neuronets.library.model

import java.util.UUID


/**
 * @param id specified id for user
 * @param name username
 */
data class UserDto(
    val id: UUID,
    val name: String,
)
