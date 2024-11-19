package proyecto_moviles.uvg.edu.gt.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable
import proyecto_moviles.uvg.edu.gt.data.model.User

@Entity(tableName = "users")
@Serializable
data class UserEntity(
    @PrimaryKey val id: String,
    val username: String,
    val email: String,
    val password: String
)

fun UserEntity.mapToUserModel(): User {
    return User(
        id = id,
        name = username,
        email = email,
        password = password,
    )
}