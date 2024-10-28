package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Project.Projects

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import proyecto_moviles.uvg.edu.gt.Projects.ProjectsScreen


@Serializable
data object ProjectsDestination

fun NavGraphBuilder.projectsScreen(
    onProjectClick: () -> Unit,
    onAddProjectClick: () -> Unit
) {
    composable<ProjectsDestination> {
        ProjectsScreen(
            onSelectClick = onProjectClick,
            onAddProjectClick = onAddProjectClick
        )
    }
}