package proyecto_moviles.uvg.edu.gt.presentacion.Inicio

import java.lang.Error

data class InicioState(
    val isLoading: Boolean = false,
    val isError: Error
    val isSuccessful: Boolean = false,
)