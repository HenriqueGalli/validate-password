package com.henrique.securepassword.exception

class PasswordNotValidExceptions(errorList: List<String>) : RuntimeException(errorList.joinToString(", ")) {
    constructor() : this(listOf("A senha não está no padrão desejado."))

}