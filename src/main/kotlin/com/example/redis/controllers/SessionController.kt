package com.example.redis.controllers

import com.example.redis.dtos.LoginRequest
import com.example.redis.services.LoginService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/login")
class SessionController(
    private val loginService: LoginService
) {

    @PostMapping
    fun login(
        @RequestBody loginRequest: LoginRequest
    ): Long {
        return loginService.login(loginRequest.username)
    }
}
