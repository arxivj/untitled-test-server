package com.arxivj.untitled.auth.controller

import com.arxivj.untitled.auth.model.dto.AuthRequest
import com.arxivj.untitled.auth.model.dto.AuthResponse
import com.arxivj.untitled.auth.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authService: AuthService) {
    @PostMapping("/login")
    fun login(@RequestBody authRequest: AuthRequest): ResponseEntity<AuthResponse> {
//        val authResponse = authService.으아아아(authRequest)
        // 일단 오고가나 보자구
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
}