package proyecto_moviles.uvg.edu.gt.data.di

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import proyecto_moviles.uvg.edu.gt.data.network.api.UserApi
import proyecto_moviles.uvg.edu.gt.data.network.dto.UserDto
import proyecto_moviles.uvg.edu.gt.data.network.util.NetworkError
import proyecto_moviles.uvg.edu.gt.data.network.util.safeCall
import proyecto_moviles.uvg.edu.gt.data.network.util.Result

class KtorUserApi(
    private val client: HttpClient
): UserApi{
    override suspend fun getAllUsers(): Result<UserDto, NetworkError> {
        return safeCall<UserDto>{
            client.get("https://jsonplaceholder.typicode.com/users")
        }
    }

    override suspend fun getUserById(id: Int): Result<UserDto, NetworkError> {
        return safeCall<UserDto>{
            client.get("https://jsonplaceholder.typicode.com/users")
        }
    }

    override suspend fun createUser(user: UserDto): Result<UserDto, NetworkError> {
        return safeCall<UserDto>{
            client.get("https://jsonplaceholder.typicode.com/users")
        }
    }


    override suspend fun updateUser(id: Int, user: UserDto): Result<UserDto, NetworkError> {
        return safeCall<UserDto>{
            client.get("https://jsonplaceholder.typicode.com/users")
        }
    }

    override suspend fun deleteUser(id: Int): Result<UserDto, NetworkError> {
        return safeCall<UserDto>{
            client.get("https://jsonplaceholder.typicode.com/users")
        }
    }
}