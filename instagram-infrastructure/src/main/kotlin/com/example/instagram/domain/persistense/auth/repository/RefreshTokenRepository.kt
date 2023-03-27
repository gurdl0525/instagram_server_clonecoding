package com.example.instagram.domain.persistense.auth.repository

import com.example.instagram.domain.persistense.auth.entity.RefreshTokenJpaEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface RefreshTokenRepository: CrudRepository<RefreshTokenJpaEntity, String> {

    fun findByToken(token: String): RefreshTokenJpaEntity?
}