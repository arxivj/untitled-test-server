package com.arxivj.untitled.auth.repository

import com.arxivj.untitled.auth.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
    fun findByEmailAndPlatform(email: String, platform: String): User?
}