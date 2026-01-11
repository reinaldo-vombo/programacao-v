package com.example.login

import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import com.example.login.data.api.RetrofitInstance
import com.example.login.data.model.LoginRequest



import com.example.login.ui.*


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var screen by remember { mutableStateOf("splash") }

            when (screen) {
                "splash" -> SplashScreen { screen = "login" }
                "login" -> LoginScreen(
                    onLoginSuccess = { screen = "home" },
                    onGoToRegister = { screen = "register" }
                )
                "register" -> RegisterScreen {
                    screen = "login"
                }
                "home" -> HomeScreen {
                    screen = "login"
                }
            }
        }
    }
}