package proyecto_moviles.uvg.edu.gt.presentacion.login.SingUp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import proyecto_moviles.uvg.edu.gt.domain.repository.UserRepository


class SignUpViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _state = mutableStateOf(SignUpState())
    val state: State<SignUpState> = _state

    fun onEvent(event: SignUpEvent) {
        when (event) {
            is SignUpEvent.UsernameChanged -> {
                _state.value = state.value.copy(username = event.username)
            }
            is SignUpEvent.EmailChanged -> {
                _state.value = state.value.copy(email = event.email)
            }
            is SignUpEvent.PasswordChanged -> {
                _state.value = state.value.copy(password = event.password)
            }
            is SignUpEvent.SignUpClicked -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        viewModelScope.launch {
            _state.value = state.value.copy(isLoading = true)
            val result = userRepository.signUp(
                state.value.username,
                state.value.email,
                state.value.password
            )
            _state.value = state.value.copy(
                isLoading = false,
                error = result.exceptionOrNull()?.message
            )
        }
    }
}