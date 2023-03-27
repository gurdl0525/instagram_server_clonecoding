package com.example.instagram.domain.persistense.auth.mapper

import com.example.instagram.domain.auth.model.RefreshToken
import com.example.instagram.domain.persistense.auth.entity.RefreshTokenJpaEntity
import org.springframework.stereotype.Component

@Component
class RefreshTokenMapper{

    fun toEntity(refreshToken: RefreshToken) = RefreshTokenJpaEntity(
        refreshToken.accountId,
        refreshToken.token
    )

    fun toDomain(refreshTokenEntity: RefreshTokenJpaEntity?): RefreshToken?{

        return refreshTokenEntity?.let {
            RefreshToken(
                refreshTokenEntity.accountId,
                refreshTokenEntity.token
            )
        }
    }
}