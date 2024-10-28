package proyecto_moviles.uvg.edu.gt.Create_Proyecto

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object CreateProjectDestination

fun NavGraphBuilder.createProjectScreen() {
    composable<CreateProjectDestination> {
        CreateProjectScreenContent()
    }
}