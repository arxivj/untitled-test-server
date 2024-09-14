package com.arxivj.untitled.auth.model.dto

data class AuthRequest(
    val oauthId: String? = null,
    val email: String? = null,
    val oauthToken: String? = null,
    val password: String? = null,
    val platform: String
)