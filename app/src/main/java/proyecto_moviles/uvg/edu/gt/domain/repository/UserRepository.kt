package proyecto_moviles.uvg.edu.gt.domain.repository

import proyecto_moviles.uvg.edu.gt.data.local.dao.UserDao
import proyecto_moviles.uvg.edu.gt.data.local.entity.UserEntity
import proyecto_moviles.uvg.edu.gt.data.network.util.AuthService

class UserRepository(
    private val authService: AuthService,
    private val userDao: UserDao
) {
    suspend fun login(username: String, password: String): Result<Boolean> {
        return try {
            val result = authService.login(username, password)
            if (result.isSuccess) {
                val user = userDao.getUser(username, password)
                Result.success(user != null)
            } else {
                result
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun signUp(username: String, email: String, password: String): Result<Boolean> {
        return try {
            val result = authService.signUp(username, email, password)
            if (result.isSuccess) {
                userDao.insertUser(
                    UserEntity(
                        username = username,
                        email = email,
                        password = password
                    )
                )
                Result.success(true)
            } else {
                result
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}