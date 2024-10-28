package proyecto_moviles.uvg.edu.gt.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import proyecto_moviles.uvg.edu.gt.Sing_up.SignUpDestination
import proyecto_moviles.uvg.edu.gt.login.LoginRoute


@Serializable
data object LoginDestination

fun NavGraphBuilder.loginScreen(
    onNavigateToSignUp: () -> Unit,
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