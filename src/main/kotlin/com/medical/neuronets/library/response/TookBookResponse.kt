package com.medical.neuronets.library.response

import com.medical.neuronets.library.entity.TookBookEntity
import java.sql.Timestamp
import java.util.UUID


// val userID: UUID?,


class TookBookResponse(val id: UUID?,  val bookID: UUID?, val userID: UUID?,
                       val isReturned: Boolean, val tookDate: Timestamp, returnDate: Timestamp) {
    constructor(tookBookEntity: TookBookEntity): this(
        id = tookBookEntity.id,
        userID = tookBookEntity.user?.id,
        bookID = tookBookEntity.book?.id,
        isReturned = tookBookEntity.isReturned,
        tookDate = tookBookEntity.tookDate,
        returnDate = tookBookEntity.returnDate
    )
}