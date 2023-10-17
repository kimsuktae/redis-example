package com.example.redis.repositories

import java.time.Duration
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Repository

@Repository
class RedisRepository(
    private val redisTemplate: RedisTemplate<String, String>
) {
    fun increaseCount(username: String): Long {
        return redisTemplate.opsForValue().increment("$PREFIX:$username", 1).also { count ->
            redisTemplate.expire("$PREFIX:$username", TTL)
            count
        } ?: 1L
    }

    companion object {
        private const val PREFIX = "LOGIN_TRY"
        private val TTL = Duration.ofSeconds(30)
    }
}
