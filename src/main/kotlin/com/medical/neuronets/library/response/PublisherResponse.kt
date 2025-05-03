package com.medical.neuronets.library.response

import com.medical.neuronets.library.entity.PublisherEntity
import java.util.UUID


data class PublisherResponse(val id: UUID?, val name: String) {
    constructor(publisherEntity: PublisherEntity): this(
        id = publisherEntity.id,
        name = publisherEntity.name
    )
}
