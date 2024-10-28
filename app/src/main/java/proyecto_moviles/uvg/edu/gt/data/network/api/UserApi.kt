package proyecto_moviles.uvg.edu.gt.data.network.api

import proyecto_moviles.uvg.edu.gt.data.network.dto.UserDto
import proyecto_moviles.uvg.edu.gt.data.network.util.NetworkError

interface UserApi{
    suspend fun getAllUsers(): Result<UserDto, NetworkError>
    suspend fun getUserById(id: Int): Result<UserDto, NetworkError>
    suspend fun createUser(user: UserDto): Result<UserDto, NetworkError>
    suspend fun updateUser(id: Int, user: UserDto): Result<UserDto, NetworkError>
    suspend fun deleteUser(id: Int): Result<Unit, NetworkError>

}