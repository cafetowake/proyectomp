package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> get() = _state

    fun updateUsername(username: String) {
        _state.value = _state.value.copy(username = username)
    }

    fun updateEmail(email: String) {
        _state.value = _state.value.copy(email = email)
    }

    fun updatePassword(password: String) {
        _state.value = _state.value.copy(password = password)
    }

    fun saveProfile() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            // Simula una operación de guardado
            _state.value = _state.value.copy(isLoading = false)
        }
    }

    fun setError(error: Boolean) {
        _state.value = _state.value.copy(isError = error)
    }
}
