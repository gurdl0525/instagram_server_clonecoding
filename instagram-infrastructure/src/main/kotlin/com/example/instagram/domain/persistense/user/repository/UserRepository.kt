package com.example.instagram.domain.persistense.user.repository

import com.example.instagram.domain.persistense.user.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository: JpaRepository<UserJpaEntity, UUID> {

    fun findByAccountId(accountId: String): UserJpaEntity?
}
