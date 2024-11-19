package proyecto_moviles.uvg.edu.gt.Inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import proyecto_moviles.uvg.edu.gt.R
import proyecto_moviles.uvg.edu.gt.presentacion.Inicio.StartState
import proyecto_moviles.uvg.edu.gt.presentacion.Inicio.StartViewModel
import proyecto_moviles.uvg.edu.gt.presentacion.common.ErrorView
import proyecto_moviles.uvg.edu.gt.presentacion.common.LoadingView

@Composable
fun StartRoute(
    viewModel: StartViewModel = viewModel(factory = StartViewModel.Factory),
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit
){
    val state = viewModel.state.collectAsStateWithLifecycle()

    StartScreen(
        state = state,
        onLoginClick = onLoginClick,
        onSignUpClick = onSignUpClick,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun StartScreen(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier
){
    Box(
        modifier = Modifier
    ){
        when{
            state.isLoading -> {
                LoadingView(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            state.isError -> {
                ErrorView(
                    onRetryClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            else{
                items(state.data) { user ->
                    StartItem(
                        user = user,
                        onLoginClick = onLoginClick,
                        onSignUpClick = onSignUpClick,
                        modifier = Modifier.fillMaxSize(),
                }
            }
        }
    }
}

@Composable
private fun StartItem(
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        val image: Painter = painterResource(id = R.drawable.logo)
        Image(
            painter = image,
            contentDescription = "Login Icon",
            modifier = Modifier.size(240.dp),
        )

        Spacer(modifier = Modifier.height(48.dp))


        Button(
            onClick = onLoginClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "Log In",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = onSignUpClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onPrimaryContainer
            ),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                text = "Sign Up",
                color = MaterialTheme.colorScheme.primaryContainer,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


