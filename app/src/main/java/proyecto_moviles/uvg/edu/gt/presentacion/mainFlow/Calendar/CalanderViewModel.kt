package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Calendar

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CalendarViewModel : ViewModel() {
    private val _state = MutableStateFlow(CalendarState())
    val state: StateFlow<CalendarState> = _state.asStateFlow()

    fun onEvent(event: CalendarEvent) {
        when (event) {
            is CalendarEvent.SelectDate -> {
                _state.value = _state.value.copy(selectedDate = event.date)
                loadEventsForDate(event.date)
            }
            is CalendarEvent.LoadEvents -> {
                loadEventsForDate(_state.value.selectedDate)
            }
        }
    }

    private fun loadEventsForDate(date: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {

                _state.value = _state.value.copy(
                    events = events,
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}