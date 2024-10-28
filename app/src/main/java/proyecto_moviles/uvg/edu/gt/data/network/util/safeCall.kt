package proyecto_moviles.uvg.edu.gt.data.network.util

import proyecto_moviles.uvg.edu.gt.data.model.User

suspend fun <T> safeCall(action: suspend () -> T): Result<T> =
    try {
        Result.success(action())
    } catch (e: Exception) {
        Result.failure(e)
    }