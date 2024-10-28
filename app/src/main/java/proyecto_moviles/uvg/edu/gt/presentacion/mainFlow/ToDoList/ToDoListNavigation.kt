package proyecto_moviles.uvg.edu.gt.ToDoList

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ToDoListDestination

fun NavGraphBuilder.todoListScreen(
    onAddTaskClick: () -> Unit,
    onCalendarClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    composable<ToDoListDestination> {
        ToDoListScreenContent(
            onAddTaskClick = onAddTaskClick,
            onCalendarClick = onCalendarClick,
            onProfileClick = onProfileClick
        )
    }
}