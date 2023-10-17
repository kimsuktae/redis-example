package com.example.redis.services

import com.example.redis.repositories.RedisRepository
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val redisRepository: RedisRepository
) {
    fun login(username: String): Long {
        val count = redisRepository.increaseCount(username)

        if (count > MAX_TRY) {
            throw RuntimeException()
        }

        return count
    }

    companion object {
        private const val MAX_TRY = 5
    }
}
