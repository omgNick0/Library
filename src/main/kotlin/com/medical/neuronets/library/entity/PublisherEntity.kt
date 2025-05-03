package com.medical.neuronets.library.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID


@Entity
@Table(name = "publisher")
class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null

    @Column(name="name")
    var name: String = ""

    @OneToMany(mappedBy = "publisher")
    var books: Set<BookEntity> = setOf()
}
