package com.medical.neuronets.library.model

import java.util.UUID

/**
 * @param id Specified id for each book in a library
 * @param title Represents title of the current book
 * @param author Each book has its own author
 * @param year Book's year of publishing
 * @param publisherId Publisher identifier
 * @param pageCount How many pages book has
 */
data class BookDto(
    val title: String,
    val author: String,
    val year: UInt,
    val publisherId: UUID,
    var pageCount: UInt = 0u
)
// у многих издательств - много разных книг - через внешнюю таблицу
