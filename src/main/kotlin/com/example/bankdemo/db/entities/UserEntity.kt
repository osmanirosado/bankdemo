package com.example.bankdemo.db.entities

import jakarta.persistence.*

@Entity
@Table(name = "bank_user")
open class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Int = 0

    @Column(name = "username", nullable = false, length = 30)
    open var username: String = ""

    @Column(name = "name", length = 250)
    open var name: String? = null

    @Column(name = "age")
    open var age: Int? = null
}