package com.henrique.securepassword.controllers

import com.henrique.securepassword.model.Pass
import com.henrique.securepassword.service.ValidatePasswordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ValidatePasswordController {

    @Autowired
    private lateinit var validatePasswordService: ValidatePasswordService

    @PostMapping("/validate-password")
    fun validatePassword(
        @RequestBody password: Pass
    ): ResponseEntity<Unit>{
        val pass = password.password
        validatePasswordService.validatePassword(pass)
        return ResponseEntity.noContent().build()
    }
}