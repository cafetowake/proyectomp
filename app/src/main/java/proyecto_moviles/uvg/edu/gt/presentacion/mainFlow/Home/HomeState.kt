package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Home

data class HomeState(
    val projects: List<String> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)