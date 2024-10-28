package proyecto_moviles.uvg.edu.gt.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Int? = null,
    val username: String,
    val email: String,
    val password: String
)