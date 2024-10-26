package proyecto_moviles.uvg.edu.gt.Calendar

import androidx.navigation.NavController
import kotlinx.serialization.Serializable

@Serializable
sealed class CalendarDestination(val route: String) {
    data object Calendar : CalendarDestination("calendar")
}

fun NavController.navigateToCalendar() {
    this.navigate(CalendarDestination.Calendar.route)
}