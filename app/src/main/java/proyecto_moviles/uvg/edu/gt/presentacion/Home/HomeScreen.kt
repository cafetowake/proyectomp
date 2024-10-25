package proyecto_moviles.uvg.edu.gt.Home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "To do list") },
                    label = { Text("To do list") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.CalendarToday, contentDescription = "Calendar") },
                    label = { Text("Calendar") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "No active projects", color = MaterialTheme.colorScheme.onBackground)
            Spacer(modifier = Modifier.height(16.dp))
            FloatingActionButton(
                onClick = { /*TODO*/ },
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
