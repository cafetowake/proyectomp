package proyecto_moviles.uvg.edu.gt.Sing_up

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import proyecto_moviles.uvg.edu.gt.login.LoginRoute
import proyecto_moviles.uvg.edu.gt.navigation.LoginDestination

@Serializable
data object SignUpDestination

fun NavGraphBuilder.loginScreen(
    onLoginClick: () -> Unit
) {
    composable<LoginDestination> {
        LoginRoute(
            onSuccessfulLogin = onLoginClick,
            onNavigateToSignUp = onNavigateToSignUp
        )
    }
}

fun NavGraphBuilder.signUpScreen(
    onSignUpClick: () -> Unit
) {
    composable<SignUpDestination> {
        SignUpRoute(
            onSuccessfulSignUp = onSignUpClick,
            onNavigateToLogin = onNavigateToLogin
        )
    }
}