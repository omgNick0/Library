package com.medical.neuronets.library.response

import com.medical.neuronets.library.entity.UserEntity
import java.util.UUID

class UserResponse(val id: UUID?, val name: String) {
    constructor(userEntity: UserEntity) : this(
        id = userEntity.id,
        name = userEntity.name
    )
}