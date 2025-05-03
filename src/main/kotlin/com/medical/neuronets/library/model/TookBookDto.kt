package com.medical.neuronets.library.model

import java.sql.Timestamp
import java.util.UUID


/**
 * @param id just an id
 * @param userID userID
 * @param bookID bookID
 * @param isReturned were your book returned or not
 * @param tookDate when was the current book taken
 * @param returnDate when was the current book returned
 */

// deleted user ID:  val userID: UUID
data class TookBookDto(val id: UUID, val bookID: UUID, val userID: UUID,
                       var isReturned: Boolean, var tookDate: Timestamp, var returnDate: Timestamp)