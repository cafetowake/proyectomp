package proyecto_moviles.uvg.edu.gt.Calendar

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.NavController

fun NavGraphBuilder.calendarNavigation(navController: NavController) {
    composable("calendar") {
        CalanderScreen(navController)
    }
}
