package proyecto_moviles.uvg.edu.gt.Login

import androidx.navigation.NavController
import kotlinx.serialization.Serializable

@Serializable
sealed class LoginDestination(val route: String) {
    data object Login : LoginDestination("login")
}

fun NavController.navigateToLogin() {
    this.navigate(LoginDestination.Login.route)
}