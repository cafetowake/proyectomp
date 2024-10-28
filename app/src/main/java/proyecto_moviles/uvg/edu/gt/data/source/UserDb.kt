package proyecto_moviles.uvg.edu.gt.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import proyecto_moviles.uvg.edu.gt.data.local.dao.UserDao
import proyecto_moviles.uvg.edu.gt.data.network.dto.UserDto

@Database(entities = [UserDto::class], version = 1)
abstract class UserDb : RoomDatabase() {
    abstract fun userDao(): UserDao
}