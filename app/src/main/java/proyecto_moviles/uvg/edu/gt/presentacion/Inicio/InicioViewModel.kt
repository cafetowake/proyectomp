package proyecto_moviles.uvg.edu.gt.presentacion.Inicio

import androidx.compose.ui.window.application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import proyecto_moviles.uvg.edu.gt.data.network.api.UserApi

class StartViewModel(
    private val userApi: UserApi,
): ViewModel() {
    private val _state = MutableStateFlow(StartState())
    val state = _state.asStateFlow()

    init {
        getUser()
    }

    private fun getUser(){
        viewModelScope.launch {
            userApi
                .getAllUsers()
                .map{ response -> response.data.map{it.mapToUser()}}
                .onSuccess { users ->
                    _state.update { it.copy(
                        isLoading = false,
                        user = users
                    ) }
                }
                .onFailure { error ->
                    _state.update { it.copy(
                        isLoading = false,
                        isError = true
                    ) }

                    println (error)
                }



        }
    }

    companion object {
        val Factory: viewModelProvider.Factory = viewModelFactory {
            initializer{
                val userApi = application.container.userApi
                StartViewModel(userApi)
            }
        }
    }
}