package proyecto_moviles.uvg.edu.gt.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val title: String,
    val description: String,
    val date: String
)