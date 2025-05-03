package com.medical.neuronets.library.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "book")
class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null

    @Column(name = "title")
    var title: String = ""

    @Column(name = "author")
    var author: String = ""

    @Column(name = "years")
    var year: UInt = 0u

    @Column(name = "pageCount")
    var pageCount: UInt = 0u

    @ManyToOne
    @JoinColumn(name = "publisherId")
    var publisher: PublisherEntity? = null
}
