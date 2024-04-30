package com.henrique.securepassword.controllers

import com.henrique.securepassword.exception.PasswordNotValidExceptions
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(PasswordNotValidExceptions::class)
    fun handleValidatePasswordException(exception: PasswordNotValidExceptions): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(exception.message)
    }
}