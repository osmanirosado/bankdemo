package com.example.bankdemo.db.repositories

import com.example.bankdemo.db.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity, Int> {
}