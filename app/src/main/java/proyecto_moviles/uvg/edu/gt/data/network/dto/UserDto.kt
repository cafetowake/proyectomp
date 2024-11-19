package proyecto_moviles.uvg.edu.gt.data.network.dto

import kotlinx.serialization.Serializable
import proyecto_moviles.uvg.edu.gt.data.local.entity.UserEntity
import proyecto_moviles.uvg.edu.gt.data.model.User

@Serializable
data class UserDto(
    val id: String,
    val username: String,
    val email: String,
    val password: String
)

fun UserDto.mapToUser(): User {
    return User(
        id = id,
        name = username,
        email = email,
        password = password
    )
}

fun UserDto.toEntity(): UserEntity {
    return UserEntity(
        id = id,
        username = username,
        email = email,
        password = password
    )
}