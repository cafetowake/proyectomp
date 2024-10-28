package proyecto_moviles.uvg.edu.gt.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import proyecto_moviles.uvg.edu.gt.R
import proyecto_moviles.uvg.edu.gt.data.model.User
import proyecto_moviles.uvg.edu.gt.presentacion.login.Login.LoginEvent
import proyecto_moviles.uvg.edu.gt.presentacion.login.Login.LoginState

@Composable
fun LoginRoute() {
    val login = UserApi.getUser().map {UserDTO->
        User(
            id = UserDTO.id,
            email = UserDTO.email,
            name = UserDTO.username
        )
    }

    val state by viewModel.state.collectAsState()
    LoginScreen(
        state = LoginState,
        onLoginClick = onLoginClick,
        onNavigateToSignUp = onNavigateToSignUp
    )
}

@Composable
fun LoginScreen(
    isLoading: Boolean,
    loginSuccessful: Boolean,
    onSuccessfulLogin: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    onLoginClick: () -> Unit,
) {

    LaunchedEffect(key1 = loginSuccessful) {
        if (loginSuccessful) {
            onSuccessfulLogin()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.tertiary)
    ) {

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .offset(x = (-70).dp, y = (-120).dp)
                .alpha(0.2f)
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .offset(x = (70).dp, y = (520).dp)
                .alpha(0.2f)
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Text(
                text = "Welcome Back",
                color = MaterialTheme.colorScheme.onTertiary,
                fontSize = 80.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 40.dp)
            )


            val username = remember { mutableStateOf("") }
            TextField(
                value = username.value,
                onValueChange = { username.value = it },
                label = { Text("Username", color = MaterialTheme.colorScheme.onSurface) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface
                )
            )


            val password = remember { mutableStateOf("") }
            val passwordVisible = remember { mutableStateOf(false) }
            TextField(
                value = password.value,
                onValueChange = { password.value = it },
                label = { Text("Password", color = MaterialTheme.colorScheme.onSurface) },
                visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                        Image(
                            painter = if (passwordVisible.value) painterResource(R.drawable.visibility_off_24px) else painterResource(R.drawable.visibility_24px),
                            contentDescription = if (passwordVisible.value) "Hide password" else "Show password"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = MaterialTheme.colorScheme.onSurface
                )
            )


            Button(
                onClick = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(bottom = 8.dp),
                colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onTertiaryContainer)
                enabled = !isLoading
            ) {
                Text(text = "Log In", color = MaterialTheme.colorScheme.tertiaryContainer)
            }



            Spacer(modifier = Modifier.height(16.dp))


            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Don't have an account?", color = MaterialTheme.colorScheme.onBackground)
                Spacer(modifier = Modifier.width(4.dp))
                TextButton(onClick = onNavigateToSignUp) {
                    Text(text = "Sign Up", color = MaterialTheme.colorScheme.onTertiaryContainer, fontWeight = FontWeight.Bold, modifier = Modifier.width(60.dp))
                }
            }
        }
    }
}

