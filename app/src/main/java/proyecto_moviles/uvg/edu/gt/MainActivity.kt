package proyecto_moviles.uvg.edu.gt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import proyecto_moviles.uvg.edu.gt.ui.theme.ProyectomovilesTheme
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()  // Mantener la funcionalidad de edge-to-edge

        setContent {
            ProyectomovilesTheme {  // Se mantiene el uso del tema personalizado
                // Scaffold para la estructura de la UI
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Llamadas a las diferentes pantallas
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    // Invocamos las otras funciones
                    HomeScreen()
                    ProfileScreen() 
                    NewTaskScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectomovilesTheme {
        Greeting("Android")
    }
}


@Composable
fun HomeScreen() {
    // Implementación de la pantalla HomeScreen
}

@Composable
fun ProfileScreen() {
    // Implementación de la pantalla ProfileScreen
}

@Composable
fun NewTaskScreen() {
    // Implementación de la pantalla NewTaskScreen
}
