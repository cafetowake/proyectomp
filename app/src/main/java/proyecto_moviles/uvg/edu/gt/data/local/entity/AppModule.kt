package proyecto_moviles.uvg.edu.gt.data.local.entity

import android.content.Context
import androidx.room.Room
import proyecto_moviles.uvg.edu.gt.data.network.util.AuthService
import proyecto_moviles.uvg.edu.gt.domain.repository.UserRepository

object AppModule {
    private var database: AppDatabase? = null
    private var authService: AuthService? = null
    private var userRepository: UserRepository? = null

    private fun provideDatabase(context: Context): AppDatabase {
        return database ?: synchronized(this) {
            Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "app_database"
            ).build().also { database = it }
        }
    }

    private fun provideAuthService(): AuthService {
        return authService ?: AuthService.create().also { authService = it }
    }

    fun provideUserRepository(context: Context): UserRepository {
        return userRepository ?: UserRepository(
            authService = provideAuthService(),
            userDao = provideDatabase(context).userDao()
        ).also { userRepository = it }
    }
}