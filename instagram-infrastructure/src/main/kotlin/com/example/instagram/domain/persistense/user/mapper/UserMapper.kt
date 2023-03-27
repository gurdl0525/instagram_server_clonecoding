package com.example.instagram.domain.persistense.user.mapper

import com.example.instagram.domain.persistense.user.entity.UserJpaEntity
import com.example.instagram.domain.user.model.User
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toEntity(user: User?): UserJpaEntity?{

        user ?: return null

        return UserJpaEntity(
            user.id,
            user.accountId,
            user.password,
            user.name,
            user.introduction,
            user.isDeleted,
            user.isHided,
            user.link
        )
    }

    fun toDomain(userJpaEntity: UserJpaEntity?): User?{

        userJpaEntity ?: return null

        return User(
            userJpaEntity.id,
            userJpaEntity.accountId,
            userJpaEntity.password,
            userJpaEntity.name,
            userJpaEntity.introduction,
            userJpaEntity.isDeleted,
            userJpaEntity.isHided,
            userJpaEntity.link
        )
    }
}