package proyecto_moviles.uvg.edu.gt.data.network.util


import io.ktor.client.HttpClient
import org.jetbrains.skiko.OS
import proyecto_moviles.uvg.edu.gt.domain.repository.AuthServiceImpl
import proyecto_moviles.uvg.edu.gt.data.network.util.Result


interface AuthService {
    suspend fun login(username: String, password: String): Result<Boolean>
    suspend fun signUp(username: String, email: String, password: String): Result<Boolean>

    companion object {
        fun create(): AuthService {
            return AuthServiceImpl(
                client = HttpClient(OS.Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}