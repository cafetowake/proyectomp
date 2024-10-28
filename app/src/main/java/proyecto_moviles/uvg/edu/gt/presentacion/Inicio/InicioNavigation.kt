package proyecto_moviles.uvg.edu.gt.Inicio

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object StartDestination

fun NavGraphBuilder.StartScreen(
    navigateToLogin: () -> Unit,
    navigateToSignUp: () -> Unit
){
    composable<StartDestination>{
        StartRoute(
            onLoginClick = navigateToLogin,
            onSignUpClick = navigateToSignUp
        )
    }
}