package com.example.bankdemo.services

import com.example.bankdemo.db.repositories.UserRepository
import com.example.bankdemo.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {
    @Autowired
    lateinit var repository: UserRepository

    fun getUsers(): List<User> {
        return repository.findAll().map { User(it.id, it.username, it.name, it.age) }
    }
}