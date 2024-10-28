package proyecto_moviles.uvg.edu.gt.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val email: String,
    val name: String,
    val password: String
)