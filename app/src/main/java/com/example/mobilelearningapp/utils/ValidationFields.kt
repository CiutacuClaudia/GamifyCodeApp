package com.example.mobilelearningapp.utils

object ValidationFields {
    fun validateUsername(username: String):Boolean {
       return (username.length > Constants.MIN_LENGTH)
    }

    fun validateEmail(email:String):Boolean {
        return (email.matches(Constants.EMAIL_REGEX.toRegex()))
    }

    fun validatePassword(password:String):Boolean{
        return(password.matches(Constants.PASSWORD_REGEX.toRegex()))
    }
}