package com.example.mobilelearningapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.RegisterUseCase
import com.example.mobilelearningapp.R
import com.example.mobilelearningapp.utils.ResourceProvider
import com.example.mobilelearningapp.utils.ValidationFields
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val resourceProvider: ResourceProvider
) : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword = _confirmPassword.asStateFlow()

    private val _emailError = MutableStateFlow<String?>(null)
    val emailError = _emailError.asStateFlow()

    private val _usernameError = MutableStateFlow<String?>(null)
    val usernameError = _usernameError.asStateFlow()

    private val _passwordError = MutableStateFlow<String?>(null)
    val passwordError = _passwordError.asStateFlow()

    private val _confirmPasswordError = MutableStateFlow<String?>(null)
    val confirmPasswordError = _confirmPasswordError.asStateFlow()

    private val _isRegisterButtonEnabled = MutableStateFlow(false)
    val isRegisterButtonEnabled = _isRegisterButtonEnabled.asStateFlow()
    fun setUsername(username: String) {
        _username.tryEmit(username)
        if (ValidationFields.validateUsername(username)) {
            _usernameError.tryEmit(null)
        } else {
            _usernameError.tryEmit(resourceProvider.getString(R.string.username_validation))
        }
        enableRegisterButton()
    }

    fun setEmail(email: String) {
        _email.tryEmit(email)
        if (ValidationFields.validateEmail(email)) {
            _emailError.tryEmit(null)
        } else {
            _emailError.tryEmit(resourceProvider.getString(R.string.email_validation))
        }
        enableRegisterButton()
    }

    fun setPassword(password: String) {
        _password.tryEmit(password)
        if (ValidationFields.validatePassword(password)) {
            _passwordError.tryEmit(null)
        } else {
            _passwordError.tryEmit(resourceProvider.getString(R.string.password_validation))
        }
        enableRegisterButton()
    }

    fun setConfirmPassword(confirmPassword: String) {
        _confirmPassword.tryEmit(confirmPassword)
        if (_password.value == _confirmPassword.value) {
            _confirmPasswordError.tryEmit(null)
        } else {
            _confirmPasswordError.tryEmit(resourceProvider.getString(R.string.confirmPassword_validation))
        }
        enableRegisterButton()
    }

    private fun enableRegisterButton(){
        if (_emailError.value.isNullOrBlank() && _passwordError.value.isNullOrBlank() &&
            _usernameError.value.isNullOrBlank() && _confirmPasswordError.value.isNullOrBlank()&&
            _email.value.isNotEmpty() && _password.value.isNotEmpty()&&
            _confirmPassword.value.isNotEmpty()&&_username.value.isNotEmpty()) {
            _isRegisterButtonEnabled.value = true
        }
    }

    fun registerUser(email: String, password: String, username: String) {
        viewModelScope.launch {
            registerUseCase(email, password, username).collect()
        }
    }
}