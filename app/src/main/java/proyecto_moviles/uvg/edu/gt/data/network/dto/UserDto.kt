package proyecto_moviles.uvg.edu.gt.data.network.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "users")
@Serializable
data class UserDto(
    @PrimaryKey val id: String,
    val username: String,
    val email: String,
    val passwordHash: String
)