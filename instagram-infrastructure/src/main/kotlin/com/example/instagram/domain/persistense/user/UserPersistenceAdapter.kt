package com.example.instagram.domain.persistense.user

import com.example.instagram.domain.persistense.user.mapper.UserMapper
import com.example.instagram.domain.persistense.user.repository.UserRepository
import com.example.instagram.domain.user.model.User
import com.example.instagram.domain.user.port.out.UserPersistencePort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
): UserPersistencePort {


    @Transactional
    override fun saveUser(user: User) {
        userRepository.save(userMapper.toEntity(user)!!)
    }

    override fun findByAccountId(accountId: String): User? {
        return userMapper.toDomain(userRepository.findByAccountId(accountId))
    }

    @Transactional
    override fun updateProfile(user: User) {
        saveUser(user)
    }


}