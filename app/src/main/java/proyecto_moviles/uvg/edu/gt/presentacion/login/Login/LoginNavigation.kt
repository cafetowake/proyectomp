package proyecto_moviles.uvg.edu.gt.Login

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.NavController
import proyecto_moviles.uvg.edu.gt.login.LoginScreen

fun NavGraphBuilder.loginNavigation(navController: NavController) {
    composable("login") {
        LoginScreen(navController)
    }
}
