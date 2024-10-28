package proyecto_moviles.uvg.edu.gt.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import proyecto_moviles.uvg.edu.gt.data.local.entity.UserEntity

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun getUser(username: String, password: String): UserEntity?
}