package com.example.instagram.global.config.security.principal

import com.example.instagram.domain.persistense.user.entity.UserJpaEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: UserJpaEntity
): UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = ArrayList()

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.accountId

    override fun isAccountNonExpired(): Boolean = !user.isDeleted

    override fun isAccountNonLocked(): Boolean = !user.isDeleted

    override fun isCredentialsNonExpired(): Boolean = false

    override fun isEnabled(): Boolean = !user.isDeleted
}