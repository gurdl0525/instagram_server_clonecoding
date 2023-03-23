package com.example.instagram.domain.persistense.user.entity

import java.util.*
import javax.persistence.*

@Entity(name = "user")
class User(
    id: UUID,
    accountId: String,
    password: String,
    name: String,
    introduction: String?,
    isHided: Boolean,
    isDeleted: Boolean
) {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: UUID = id
        protected set

    @Column(name = "account_id", length = 20, nullable = false, unique = true)
    var accountId: String = accountId
        protected set

    @Column(name = "password", length = 60, nullable = false)
    var password: String = password
        protected set

    @Column(name = "name", length = 20, nullable = false)
    var name: String = name
        protected set

    @Column(name = "introduction", length = 60, nullable = true)
    var introduction: String? = introduction
        protected set


    @OneToMany(mappedBy = "user")
    var link: MutableList<Link> = ArrayList()
        protected set


    @Column(name = "is_hided", nullable = false)
    var isHided: Boolean = isHided
        protected set

    @Column(name = "is_deleted", nullable = false)
    var isDeleted: Boolean = isDeleted
        protected set


}