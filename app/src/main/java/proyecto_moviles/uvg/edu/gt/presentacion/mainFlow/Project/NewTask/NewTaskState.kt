package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Project.NewTask


import proyecto_moviles.uvg.edu.gt.data.model.Event
import proyecto_moviles.uvg.edu.gt.data.model.User

data class NewTaskState(
    val isLoading: Boolean = false,
    var taskName: String = "",
    var startDate: String = "",
    var endDate: String = "",
    var assignedUser: User?= null,
    var reatedEvent: Event?= null,
    val taskDescription: String = ""
)