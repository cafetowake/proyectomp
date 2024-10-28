package proyecto_moviles.uvg.edu.gt.data.network.util

import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import proyecto_moviles.uvg.edu.gt.data.network.util.NetworkError as UtilError

sealed interface Result<out D, out E : UtilError> {

    data class Success<out D>(val data: D) : Result<D, Nothing>

    data class Error<out E : UtilError>(val error: E) : Result<Nothing, E>
}

inline fun <T, E : UtilError, R> Result<T, E>.map(map: (T) -> R): Result<R, E> {
    return when (this) {
        is Result.Error -> Result.Error(error)
        is Result.Success -> Result.Success(map(data))
    }
}

inline fun <T, E : UtilError> Result<T, E>.onSuccess(action: (T) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Error -> this
        is Result.Success -> {
            action(data)
            this
        }
    }
}

inline fun <T, E : UtilError> Result<T, E>.onError(action: (E) -> Unit): Result<T, E> {
    return when (this) {
        is Result.Error -> {
            action(error)
            this
        }
        is Result.Success -> this
    }
}

suspend inline fun <reified T> responseToResult(
    response: HttpResponse
): Result<T, UtilError> {
    return when(response.status.value) {
        in 200..299 -> {
            try {
                Result.Success(response.body<T>())
            } catch(e: Exception) {
                Result.Error(UtilError.SERIALIZATION)
            }
        }

        408 -> Result.Error(UtilError.REQUEST_TIMEOUT)
        429 -> Result.Error(UtilError.TOO_MANY_REQUESTS)
        in 500..599 -> Result.Error(UtilError.SERVER_ERROR)
        else -> Result.Error(UtilError.UNKNOWN)
    }
}