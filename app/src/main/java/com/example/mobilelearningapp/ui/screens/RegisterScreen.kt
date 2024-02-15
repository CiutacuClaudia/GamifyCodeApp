package com.example.mobilelearningapp.ui.screens

import android.annotation.SuppressLint
import android.view.KeyEvent.ACTION_DOWN
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onPreviewKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mobilelearningapp.R
import com.example.mobilelearningapp.utils.Dimensions.padding16
import com.example.mobilelearningapp.viewmodels.RegisterViewModel
import timber.log.Timber

@SuppressLint("TimberArgCount")
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreen(viewModel: RegisterViewModel) {
    val keyboardController = LocalSoftwareKeyboardController.current

    val email by viewModel.email.collectAsState()
    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val confirmPassword by viewModel.confirmPassword.collectAsState()

    val emailError by viewModel.emailError.collectAsState()
    val usernameError by viewModel.usernameError.collectAsState()
    val passwordError by viewModel.passwordError.collectAsState()
    val confirmPasswordError by viewModel.confirmPasswordError.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val focusManager = LocalFocusManager.current
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.letter_g), contentDescription = null,
                modifier = Modifier.size(100.dp),
            )
            Text(
                text = "Register",
                modifier = Modifier.padding(16.dp),
                fontSize = 40.sp,
                fontFamily = FontFamily.Monospace,
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(padding16)
                    .onPreviewKeyEvent {
                        if (it.key == Key.Tab && it.nativeKeyEvent.action == ACTION_DOWN) {
                            focusManager.moveFocus(FocusDirection.Down)
                            true
                        } else {
                            false
                        }
                    },
                value = email,
                onValueChange = {
                    viewModel.setEmail(it)
                },
                label = { Text("Email") },
                isError = emailError != null,
                supportingText = emailError?.let {
                    { Text(text = emailError!!) }
                },
                placeholder = { Text("Enter your email") },
                keyboardActions = KeyboardActions.Default
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(padding16)
                    .onPreviewKeyEvent {
                        if (it.key == Key.Tab && it.nativeKeyEvent.action == ACTION_DOWN) {
                            focusManager.moveFocus(FocusDirection.Down)
                            true
                        } else {
                            false
                        }
                    },
                value = username,
                onValueChange = {
                    viewModel.setUsername(it)
                },
                label = { Text("Username") },
                isError = usernameError != null,
                supportingText = usernameError?.let {
                    { Text(text = usernameError!!) }
                },
                placeholder = { Text("Enter your username") },
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(padding16)
                    .onPreviewKeyEvent {
                        if (it.key == Key.Tab && it.nativeKeyEvent.action == ACTION_DOWN) {
                            focusManager.moveFocus(FocusDirection.Down)
                            true
                        } else {
                            false
                        }
                    },
                value = password,
                onValueChange = {
                    viewModel.setPassword(it)
                },
                label = { Text("Password") },
                isError = passwordError != null,
                supportingText = passwordError?.let {
                    { Text(text = passwordError!!, modifier = Modifier.padding(end = 60.dp)) }
                },
                placeholder = { Text("Enter your password") },
                visualTransformation = PasswordVisualTransformation(),
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(padding16)
                    .onPreviewKeyEvent {
                        if (it.key == Key.Tab && it.nativeKeyEvent.action == ACTION_DOWN) {
                            focusManager.moveFocus(FocusDirection.Down)
                            true
                        } else {
                            false
                        }
                    },
                value = confirmPassword,
                onValueChange = {
                    viewModel.setConfirmPassword(it)
                },
                label = { Text("Confirm Password") },
                isError = confirmPasswordError != null,
                supportingText = confirmPasswordError?.let {
                    { Text(text = confirmPasswordError!!) }
                },
                placeholder = { Text("Confirm your password") },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        viewModel.registerUser(email, password, username)
                    }
                )
            )

            Button(
                onClick = {
                    Timber.tag("Test2").d("$email, $password, $username")
                    viewModel.registerUser(email, password, username)
                },
            ) {
                Text("Register")
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview() {
    val viewModel: RegisterViewModel = hiltViewModel()
    RegisterScreen(viewModel = viewModel)
}