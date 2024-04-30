package com.henrique.securepassword.service.impl

import com.henrique.securepassword.exception.PasswordNotValidExceptions
import com.henrique.securepassword.model.Pass
import com.henrique.securepassword.service.ValidatePasswordService
import org.springframework.stereotype.Service

@Service
class ValidatePasswordServiceImpl : ValidatePasswordService {

    override fun validatePassword(password: String): Boolean {
        val errorList = mutableListOf<String>()
        if(!validatePasswordLenght(password))
            errorList.add("At least 8 characters necessary")
        if(!validateUpperCase(password))
            errorList.add("At least 1 upper case character necessary")
        if(!validateLowerCase(password))
            errorList.add("At least 1 lower case character necessary")
        if(!validateDigit(password))
            errorList.add("At least 1 digit necessary")
        if(!validateSpecialCharacter(password))
            errorList.add("At least 1 special character necessary")
        if(errorList.size > 0)
            throw PasswordNotValidExceptions(errorList)
        else
            return true
    }

    private fun validatePasswordLenght(password: String) = password.length >= 8

    private fun validateUpperCase(password: String): Boolean {
        val pattern = Regex("[A-Z]")
        return pattern.containsMatchIn(password)
    }

    private fun validateLowerCase(password: String): Boolean {
        val pattern = Regex("[a-z]")
        return pattern.containsMatchIn(password)
    }

    private fun validateDigit(password: String): Boolean {
        val pattern = Regex("\\d")
        return pattern.containsMatchIn(password)
    }

    private fun validateSpecialCharacter(password: String): Boolean {
        val pattern = Regex("[^a-zA-Z0-9]")
        return pattern.containsMatchIn(password)
    }
}