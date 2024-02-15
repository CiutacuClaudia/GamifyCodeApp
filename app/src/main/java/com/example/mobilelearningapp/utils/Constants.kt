package com.example.mobilelearningapp.utils

object Constants {
    const val PASSWORD_REGEX =
        "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#\$%^&+=!]).{8,}$"
    const val EMAIL_REGEX = "[A-Za-z0-9._]+@[A-Za-z0-9._]+\\.[A-Za-z]{2,}"
    const val MIN_LENGTH = 3
    const val MAX_LENGTH = 20
}