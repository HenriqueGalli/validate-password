package com.henrique.securepassword.service

import com.henrique.securepassword.model.Pass

interface ValidatePasswordService {
    fun validatePassword(password: String): Boolean
}