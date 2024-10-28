package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Calendar

sealed class CalendarEvent {
    data class SelectDate(val date: String) : CalendarEvent()
    data object LoadEvents : CalendarEvent()
}