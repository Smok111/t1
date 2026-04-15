package com.example.altokeyaa

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.altokeyaa.ui.login.LoginScreen
import com.example.altokeyaa.ui.theme.AltokeyaaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AltokeyaaTheme {
                LoginScreen(
                    onLoginSuccess = {
                        Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_SHORT).show()
                        // 🔜 FUTURO: aquí navegarás al HomeScreen
                    }
                )
            }
        }
    }
}