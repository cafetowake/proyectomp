package proyecto_moviles.uvg.edu.gt.presentacion.login.Login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import proyecto_moviles.uvg.edu.gt.domain.repository.UserRepository


class LoginViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.UsernameChanged -> {
                _state.value = state.value.copy(username = event.username)
            }
            is LoginEvent.PasswordChanged -> {
                _state.value = state.value.copy(password = event.password)
            }
            is LoginEvent.LoginClicked -> {
                login()
            }
        }
    }

    private fun login() {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)
            val result = userRepository.login(state.value.username, state.value.password)
            _state.value = state.value.copy(
                isLoading = false,
                error = result.exceptionOrNull()?.message
            )
        }
    }
}