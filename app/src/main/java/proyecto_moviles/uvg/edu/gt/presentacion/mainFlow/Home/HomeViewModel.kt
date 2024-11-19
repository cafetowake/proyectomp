package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> get() = _state

    fun addProject(project: String) {
        _state.value = _state.value.copy(projects = _state.value.projects + project)
    }

    fun setLoading(isLoading: Boolean) {
        _state.value = _state.value.copy(isLoading = isLoading)
    }

    fun setError(isError: Boolean) {
        _state.value = _state.value.copy(isError = isError)
    }
}
