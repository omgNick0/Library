package com.medical.neuronets.library.mapper

import com.medical.neuronets.library.entity.PublisherEntity
import com.medical.neuronets.library.model.PublisherDto
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
interface PublisherMapper {
    fun toDto(publisherEntity: PublisherEntity): PublisherDto
    fun toBean(publisherDto: PublisherDto): PublisherEntity
}