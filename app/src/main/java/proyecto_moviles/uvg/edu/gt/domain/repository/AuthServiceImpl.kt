package proyecto_moviles.uvg.edu.gt.domain.repository


import io.ktor.client.*
import proyecto_moviles.uvg.edu.gt.data.network.util.AuthService

class AuthServiceImpl(
    private val client: HttpClient
) : AuthService {
    override suspend fun login(username: String, password: String): Result<Boolean> {
        return try {
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signUp(username: String, email: String, password: String): Result<Boolean> {
        return try {
            Result.success(true)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}