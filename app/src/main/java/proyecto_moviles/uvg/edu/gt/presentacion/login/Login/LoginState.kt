package proyecto_moviles.uvg.edu.gt.presentacion.login.Login

import proyecto_moviles.uvg.edu.gt.data.model.User

data class LoginState(
    val id: Int,
    val name: String,
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val loginSuccessful: Boolean = false,
    val successMessage: String? = null,
    val errorMessage: String? = null

)