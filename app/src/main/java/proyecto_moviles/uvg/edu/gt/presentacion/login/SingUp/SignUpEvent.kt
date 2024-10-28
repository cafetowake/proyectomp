package proyecto_moviles.uvg.edu.gt.presentacion.login.SingUp

sealed class SignUpEvent {
    data class UsernameChanged(val username: String) : SignUpEvent()
    data class EmailChanged(val email: String) : SignUpEvent()
    data class PasswordChanged(val password: String) : SignUpEvent()
    data object SignUpClicked : SignUpEvent()
}