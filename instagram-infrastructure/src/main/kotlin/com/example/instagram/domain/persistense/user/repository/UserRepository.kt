package com.example.instagram.domain.persistense.user.repository

import com.example.instagram.domain.persistense.user.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Repository
@Transactional(readOnly = true)
interface UserRepository: JpaRepository<UserJpaEntity, UUID> {

    fun findByAccountId(accountId: String): UserJpaEntity?
}