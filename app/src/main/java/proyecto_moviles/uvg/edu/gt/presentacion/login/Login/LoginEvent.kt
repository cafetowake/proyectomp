package proyecto_moviles.uvg.edu.gt.presentacion.login.Login

sealed class LoginEvent {
    data class UsernameChanged(val username: String) : LoginEvent()
    data class PasswordChanged(val password: String) : LoginEvent()
    data object LoginClicked : LoginEvent()
}