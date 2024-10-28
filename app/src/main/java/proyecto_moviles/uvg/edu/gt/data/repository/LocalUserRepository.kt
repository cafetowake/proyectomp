package proyecto_moviles.uvg.edu.gt.data.repository

import proyecto_moviles.uvg.edu.gt.data.model.User
import proyecto_moviles.uvg.edu.gt.data.network.dto.UserDto
import proyecto_moviles.uvg.edu.gt.data.network.util.safeCall
import proyecto_moviles.uvg.edu.gt.data.source.UserDb
import proyecto_moviles.uvg.edu.gt.domain.repository.UserRepository
import java.util.UUID



class LocalUserRepository(
    private val userDb: UserDb
) : UserRepository {
    override suspend fun login(username: String, password: String): Result<User> =
        safeCall {
            val userDto = userDb.userDao().getAll().find { it.username == username }
            if (userDto != null && verifyPassword(password, userDto.passwordHash)) {
                User(userDto.id, userDto.username, userDto.email)
            } else {
                throw Exception("Invalid credentials")
            }
        }

    override suspend fun signUp(username: String, email: String, password: String): Result<User> =
        safeCall {
            val id = UUID.randomUUID().toString()
            val passwordHash = hashPassword(password)
            val userDto = UserDto(id, username, email, passwordHash)
            userDb.userDao().insert(userDto)
            User(id, username, email)
        }

    override suspend fun getUser(id: String): Result<User> =
        safeCall {
            val userDto = userDb.userDao().getById(id)
                ?: throw Exception("User not found")
            User(userDto.id, userDto.username, userDto.email)
        }

    override suspend fun logout(): Result<Unit> =
        safeCall { /* Implement logout logic */ }

    private fun hashPassword(password: String): String {
        return password
    }

    private fun verifyPassword(password: String, hash: String): Boolean {
        return password == hash
    }
}