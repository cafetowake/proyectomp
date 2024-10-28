package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Calendar

import proyecto_moviles.uvg.edu.gt.data.model.Event

data class CalendarState(
    val selectedDate: String = "",
    val events: List<Event> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)