package com.arxivj.untitled.auth.controller

import com.arxivj.untitled.auth.model.dto.AuthRequest
import com.arxivj.untitled.auth.model.dto.AuthResponse
import com.arxivj.untitled.auth.model.dto.UserResponse
import com.arxivj.untitled.auth.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authService: AuthService) {
    @PostMapping("/login")
    fun login(@RequestBody authRequest: AuthRequest): ResponseEntity<AuthResponse> {

        val platform = authRequest.platform

        val authResponse = when (platform) {
            "google" -> AuthResponse(
                accessToken = "google_accessToken",
                refreshToken = "google_refreshToken"
            )

            "apple" -> AuthResponse(
                accessToken = "apple_accessToken",
                refreshToken = "apple_refreshToken"
            )

            "emailPassword" -> AuthResponse(
                accessToken = "emailpassword_accessToken",
                refreshToken = "emailpassword_refreshToken"
            )

            else -> AuthResponse(
                accessToken = "unknown_platform",
                refreshToken = "unknown_refreshToken"
            )
        }

        return ResponseEntity.ok(authResponse)
    }

    @GetMapping("/user")
    fun getUserByAccessToken(@RequestHeader("Authorization") token: String): ResponseEntity<UserResponse> {
        val accessToken = token.removePrefix("Bearer ")
        println("온 토큰 : $accessToken")
        val userResponse = when (accessToken) {
            "google_accessToken" -> UserResponse(
                email = "user@google.com",
                platform = "google"
            )

            "apple_accessToken" -> UserResponse(
                email = "user@apple.com",
                platform = "apple"
            )

            "emailpassword_accessToken" -> UserResponse(
                email = "user@email.com",
                platform = "emailPassword"
            )

            else -> UserResponse(
                email = "unknown_user",
                platform = "unknown_platform"
            )
        }

        return ResponseEntity.ok(userResponse)
    }
}