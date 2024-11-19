package proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector

data class ProfileState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val username: String = "Username",
    val email: String = "username@gmail.com",
    val password: String = ""
)

@Composable
fun rememberProfileState(
    initialUsername: String = "Username",
    initialEmail: String = "username@gmail.com",
    initialPassword: String = ""
): MutableState<ProfileState>{
    return remember{
        mutableStateOf(ProfileState(
            username = initialUsername,
            email = initialEmail,
            password = initialPassword
        ))
    }
}