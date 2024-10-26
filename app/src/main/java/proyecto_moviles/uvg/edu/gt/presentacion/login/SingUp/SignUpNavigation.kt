package proyecto_moviles.uvg.edu.gt.Sing_up

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.NavController
import proyecto_moviles.uvg.edu.gt.Sign_up.SignUpScreen

fun NavGraphBuilder.signUpNavigation(navController: NavController) {
    composable("sign_up") {
        SignUpScreen(navController)
    }
}
