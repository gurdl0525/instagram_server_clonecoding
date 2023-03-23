package com.example.instagram.domain.persistense.user.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "link")
class Link(
    id: Long?,
    url: String,
    user: User
) {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
        protected set

    @Column(name = "url", nullable = false, length = 255)
    var url: String = url
        protected set

    @ManyToOne
    @JoinColumn(name = "user_id")
    var user: User = user
        protected set
}
