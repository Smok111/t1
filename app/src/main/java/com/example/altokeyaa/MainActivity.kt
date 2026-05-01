package com.example.altokeyaa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.example.altokeyaa.ui.home.HomeScreen
import com.example.altokeyaa.ui.login.LoginScreen
import com.example.altokeyaa.ui.orders.OrdersScreen
import com.example.altokeyaa.ui.promo.PromoScreen
import com.example.altokeyaa.ui.theme.AltokeyaaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AltokeyaaTheme {
                var currentScreen by remember { mutableStateOf("home") }

                when (currentScreen) {
                    "home" -> HomeScreen(
                        onProfileClick = { currentScreen = "login" },
                        onPromosClick = { currentScreen = "promos" },
                        onOrdersClick = { currentScreen = "orders" }
                    )
                    "promos" -> PromoScreen(onBack = { currentScreen = "home" })
                    "orders" -> OrdersScreen(onBack = { currentScreen = "home" })
                    "login" -> LoginScreen(
                        onLoginSuccess = { 
                            currentScreen = "home"
                        },
                        onBack = { currentScreen = "home" }
                    )
                }
            }
        }
    }
}
