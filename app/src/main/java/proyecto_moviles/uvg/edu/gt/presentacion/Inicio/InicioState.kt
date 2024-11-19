package proyecto_moviles.uvg.edu.gt.presentacion.Inicio

import proyecto_moviles.uvg.edu.gt.data.model.User

data class StartState(
//    val data: List<User> = emptyList(),
    val isLoading: Boolean = true,
    val isLoggedIn: Boolean = false,
    val isSignedUp: Boolean = false,
    val isError: Boolean = false,
)