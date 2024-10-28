package proyecto_moviles.uvg.edu.gt.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "users")
@Serializable
data class UserEntiy(
    @PrimaryKey val id: String,
    val username: String,
    val email: String
)