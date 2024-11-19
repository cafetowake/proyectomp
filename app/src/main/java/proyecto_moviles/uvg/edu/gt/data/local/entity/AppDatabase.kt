package proyecto_moviles.uvg.edu.gt.data.local.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import proyecto_moviles.uvg.edu.gt.data.local.dao.UserDao


@Database(
    entities = [UserEntity::class], [TaskEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}