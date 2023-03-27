package com.example.instagram.global.config.jwt.property

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.Base64

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    secretKey: String,
    accessExp: Int,
    refreshExp: Int
) {
    val secretKey: String = Base64.getEncoder().encodeToString(secretKey.toByteArray())
    val accessExp: Int = accessExp * 1000
    val refreshExp: Int = refreshExp * 1000
}