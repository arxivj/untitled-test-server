package com.arxivj.untitled.auth.service

import com.arxivj.untitled.auth.repository.UserRepository
import com.arxivj.untitled.security.JwtTokenProvider
import org.springframework.stereotype.Service

@Service
class AuthService(private val userRepository: UserRepository, private val jwtTokenProvider: JwtTokenProvider) {
}