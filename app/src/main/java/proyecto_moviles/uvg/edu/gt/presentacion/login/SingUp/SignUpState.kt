package proyecto_moviles.uvg.edu.gt.presentacion.login.SingUp

import proyecto_moviles.uvg.edu.gt.data.model.User

data class SignUpState(
    val username: User,
    val email: String ,
    val password: String ,
    val isLoading: Boolean = false,
    val error: String? = null
)