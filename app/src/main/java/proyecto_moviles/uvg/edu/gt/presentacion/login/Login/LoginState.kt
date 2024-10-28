package proyecto_moviles.uvg.edu.gt.presentacion.login.Login

import proyecto_moviles.uvg.edu.gt.data.model.User

data class LoginState(
    val username: User,
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val loginSuccessful: Boolean = false
)