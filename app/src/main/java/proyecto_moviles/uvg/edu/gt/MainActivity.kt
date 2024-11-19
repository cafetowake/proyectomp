package proyecto_moviles.uvg.edu.gt

import android.content.Context
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
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels {AuthViewModel.Factory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            ProyectomovilesTheme {
                Surface{
                    FirebaseApp
                }

//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    HomeScreen()
//                    ProfileScreen()
//                    NewTaskScreen()
//                }
            }
        }
    }
}


