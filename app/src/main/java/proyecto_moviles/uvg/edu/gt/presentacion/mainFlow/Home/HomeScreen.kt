package proyecto_moviles.uvg.edu.gt.Home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Home.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val state = viewModel.state.collectAsState().value

    Scaffold() { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.projects.isEmpty()) {
                Text(text = "No active projects", color = MaterialTheme.colorScheme.onBackground)
            } else {
                // Display the list of projects
                state.projects.forEach { project ->
                    Text(text = project, color = MaterialTheme.colorScheme.onBackground)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            FloatingActionButton(
                onClick = { viewModel.addProject("New Project") },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add", tint = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenView() {
    HomeScreen()
}
