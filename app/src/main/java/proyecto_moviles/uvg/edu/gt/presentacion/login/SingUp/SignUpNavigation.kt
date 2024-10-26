package proyecto_moviles.uvg.edu.gt.Sing_up

import androidx.navigation.NavController
import kotlinx.serialization.Serializable

@Serializable
sealed class SignUpDestination(val route: String) {
    data object SignUp : SignUpDestination("sign_up")
}

fun NavController.navigateToSignUp() {
    this.navigate(SignUpDestination.SignUp.route)
}
