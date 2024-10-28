package proyecto_moviles.uvg.edu.gt.data.network.util

import io.ktor.client.*
import proyecto_moviles.uvg.edu.gt.domain.repository.AuthServiceImpl


interface AuthService {
    suspend fun login(username: String, password: String): Result<Boolean>
    suspend fun signUp(username: String, email: String, password: String): Result<Boolean>

    companion object {
        fun create(): AuthService {
            return AuthServiceImpl(
                client = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}