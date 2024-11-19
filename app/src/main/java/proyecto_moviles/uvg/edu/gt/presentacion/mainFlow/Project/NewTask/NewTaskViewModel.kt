package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Project.NewTask



import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NewTaskViewModel : ViewModel() {

    private val _state = MutableStateFlow(NewTaskState())
    val state: StateFlow<NewTaskState> get() = _state

    fun updateTaskName(name: String) {
        _state.value = _state.value.copy(taskName = name)
    }

    fun updateTaskDescription(description: String) {
        _state.value = _state.value.copy(taskDescription = description)
    }

    fun updateStartDate(date: String) {
        _state.value = _state.value.copy(startDate = date)
    }

    fun updateEndDate(date: String) {
        _state.value = _state.value.copy(endDate = date)
    }

    fun saveTask() {
        // Lógica para guardar la tarea
    }
}
