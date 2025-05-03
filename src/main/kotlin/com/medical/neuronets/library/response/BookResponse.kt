package com.medical.neuronets.library.response

import com.medical.neuronets.library.entity.BookEntity
import java.util.*

data class BookResponse(
    val id: UUID?, val title: String, val author: String, val year: UInt, val pageCount: UInt,
    val publisher: PublisherResponse?) {
    constructor(bookEntity: BookEntity): this(
        id = bookEntity.id,
        title = bookEntity.title,
        author = bookEntity.author,
        year = bookEntity.year,
        pageCount = bookEntity.pageCount,
        publisher = bookEntity.publisher?.let { PublisherResponse(it) }
    )
}
