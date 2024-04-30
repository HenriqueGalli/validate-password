package com.henrique.securepassword

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SecurePasswordApplication

fun main(args: Array<String>) {
	runApplication<SecurePasswordApplication>(*args)
}
