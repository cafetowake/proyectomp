package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Calendar

data class CalendarState(
    val selectedDate: String = "",
    val events: List<Event> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)