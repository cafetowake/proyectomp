package proyecto_moviles.uvg.edu.gt.presentacion.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import proyecto_moviles.uvg.edu.gt.Calendar.CalendarDestination
import proyecto_moviles.uvg.edu.gt.Calendar.CalendarScreen
import proyecto_moviles.uvg.edu.gt.Calendar.navigateToCalendar
import proyecto_moviles.uvg.edu.gt.Login.LoginDestination
import proyecto_moviles.uvg.edu.gt.Login.navigateToLogin
import proyecto_moviles.uvg.edu.gt.Sign_up.SignUpScreen
import proyecto_moviles.uvg.edu.gt.Sing_up.SignUpDestination
import proyecto_moviles.uvg.edu.gt.Sing_up.navigateToSignUp
import proyecto_moviles.uvg.edu.gt.login.LoginScreen


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LoginDestination.Login.route) {
        composable(LoginDestination.Login.route) {
            LoginScreen(
                onNavigateToHome = { navController.navigateToCalendar() },
                onNavigateToSignUp = { navController.navigateToSignUp() }
            )
        }
        composable(SignUpDestination.SignUp.route) {
            SignUpScreen(
                onNavigateToHome = { navController.navigateToCalendar() },
                onNavigateToLogin = { navController.navigateToLogin() }
            )
        }
        composable(CalendarDestination.Calendar.route) {
            CalendarScreen(
                onNavigateToToDo = { /* Navegar a ToDo list */ },
                onNavigateToProfile = { /* Navegar a Profile */ }
            )
        }
    }
}
