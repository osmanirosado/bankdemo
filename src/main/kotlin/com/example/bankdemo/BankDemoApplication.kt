package com.example.bankdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BankDemoApplication

fun main(args: Array<String>) {
    runApplication<BankDemoApplication>(*args)
}
