// ui/login/LoginViewModel.kt
package com.example.altokeyaa.ui.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isLoginSuccess: Boolean = false,
    val isLoading: Boolean = false
)

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChange(value: String) {
        _uiState.value = _uiState.value.copy(email = value, emailError = null)
    }

    fun onPasswordChange(value: String) {
        _uiState.value = _uiState.value.copy(password = value, passwordError = null)
    }

    fun onLoginClick() {
        val state = _uiState.value
        var hasError = false

        if (state.email.isBlank() || !state.email.contains("@")) {
            _uiState.value = _uiState.value.copy(emailError = "Correo inválido")
            hasError = true
        }
        if (state.password.length < 6) {
            _uiState.value = _uiState.value.copy(passwordError = "Mínimo 6 caracteres")
            hasError = true
        }
        if (hasError) return

        // ✅ Por ahora: login simulado con credenciales fijas
        // 🔜 FUTURO: reemplaza esto por una llamada a tu API/base de datos
        if (state.email == "admin@test.com" && state.password == "123456") {
            _uiState.value = _uiState.value.copy(isLoginSuccess = true)
        } else {
            _uiState.value = _uiState.value.copy(passwordError = "Credenciales incorrectas")
        }
    }
}