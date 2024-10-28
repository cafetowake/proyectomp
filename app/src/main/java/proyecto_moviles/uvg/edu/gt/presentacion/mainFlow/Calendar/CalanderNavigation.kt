package proyecto_moviles.uvg.edu.gt.Calendar

import androidx.navigation.NavController
import kotlinx.serialization.Serializable

@Serializable
data class CalendarDestination(
    val id : Int
)

fun NavController.navigateToCalendar(
    eventID: Int
) {
    this.navigate(CalendarDestination(id = eventID))
}

fun NavController.Calendar(
    onNavigationBack: () -> Unit
) {
    composable<CalendarDestination> {
        CalendarRoute(
            onNavigationBack = onNavigationBack
        )
    }
}