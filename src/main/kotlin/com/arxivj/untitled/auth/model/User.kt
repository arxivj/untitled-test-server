package com.arxivj.untitled.auth.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name= "users")
data class User(
    @Id
    val id: String, // 고유식별자는 oauth: oauthId, emailPassword: email+platform
    val email: String,
    val platform: String,
    val password: String? = null // oauth 유저는 비밀번호가 없어서 nullable
)