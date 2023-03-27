package com.example.instagram.global.config.security.principal

import com.example.instagram.domain.persistense.user.repository.UserRepository
import com.example.instagram.domain.user.exception.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService(
    private val userRepository: UserRepository
) : UserDetailsService {

    override fun loadUserByUsername(accountId: String): UserDetails {
        return AuthDetails(userRepository.findByAccountId(accountId)
            ?: throw UserNotFoundException)
    }
}