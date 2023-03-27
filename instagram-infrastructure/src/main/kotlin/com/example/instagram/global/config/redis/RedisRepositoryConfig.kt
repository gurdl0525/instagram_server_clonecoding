package com.example.instagram.global.config.redis

import com.example.instagram.global.config.redis.property.RedisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories
import org.springframework.data.redis.serializer.StringRedisSerializer

@EnableRedisRepositories
@Configuration
class RedisRepositoryConfig(
    private val property: RedisProperties
){

    @Bean
    fun redisConnectionFactory(): RedisConnectionFactory = LettuceConnectionFactory(property.host, property.port)

    @Bean
    fun redisTemplate(): RedisTemplate<String, String>{

        val template: RedisTemplate<String, String> = RedisTemplate()

        template.let {
            it.keySerializer = StringRedisSerializer()
            it.valueSerializer = StringRedisSerializer()
            it.setConnectionFactory(redisConnectionFactory())
        }

        return template
    }
}