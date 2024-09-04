package com.example.bankdemo.controllers

import com.example.bankdemo.domain.User
import com.example.bankdemo.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun getUsers (): ResponseEntity<List<User>> {
        return ResponseEntity(userService.getUsers(), HttpStatus.OK)
    }
}