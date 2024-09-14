package com.arxivj.untitled.auth.model.dto

data class AuthResponse(
    val accessToken: String,
    val refreshToken: String
)