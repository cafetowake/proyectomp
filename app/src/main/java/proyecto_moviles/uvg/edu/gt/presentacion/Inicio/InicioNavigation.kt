package proyecto_moviles.uvg.edu.gt.Inicio

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.NavController

fun NavGraphBuilder.inicioNavigation(navController: NavController) {
    composable("inicio") {
        StartScreen(navController)
    }
}
