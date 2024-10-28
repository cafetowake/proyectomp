package proyecto_moviles.uvg.edu.gt.data.network.util

fun <T> responseToResult(response: T?): Result<T> =
    response?.let { Result.success(it) } ?: Result.failure(Exception("Response was null"))