package com.medical.neuronets.library.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.sql.Timestamp
import java.util.UUID

@Entity
@Table(name = "tookedBooks")
class TookBookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null

    @Column(name = "isReturned")
    var isReturned: Boolean = true

    @Column(name = "tookDate")
    var tookDate: Timestamp = Timestamp(System.currentTimeMillis())

    @Column(name = "returnDate")
    var returnDate: Timestamp = Timestamp(System.currentTimeMillis())


    @ManyToOne
    @JoinColumn(name = "userID")
    var user: UserEntity? = null

    @ManyToOne
    @JoinColumn(name = "bookID")
    var book: BookEntity? = null
}
