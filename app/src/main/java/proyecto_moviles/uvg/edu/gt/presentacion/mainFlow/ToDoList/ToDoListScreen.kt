package proyecto_moviles.uvg.edu.gt.ToDoList

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import proyecto_moviles.uvg.edu.gt.R

class ToDoListScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListScreenContent(
                onAddTaskClick = { /* Acción al hacer clic en "Add new task" */ },
                onCalendarClick = { /* Acción al hacer clic en el ícono del calendario */ },
                onProfileClick = { /* Acción al hacer clic en el ícono de perfil */ }
            )
        }
    }
}

@Composable
fun ToDoListScreenContent(
    onAddTaskClick: () -> Unit,
    onCalendarClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(onCalendarClick, onProfileClick) } // Barra de navegación en la parte inferior
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Parte superior de la pantalla
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp), // Ajusta la altura de la imagen
                contentAlignment = Alignment.BottomStart
            ) {
                // Imagen de fondo
                Image(
                    painter = painterResource(id = R.drawable.ic_placeholder),
                    contentDescription = "Background",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                // Texto "Calculus 2"
                Text(
                    text = "Calculus 2",
                    style = MaterialTheme.typography.headlineLarge.copy(color = MaterialTheme.colorScheme.onBackground),
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp, bottom = 20.dp) // Ajusta el padding si es necesario
                )

                // Botón "Add new task"
                Button(
                    onClick = onAddTaskClick,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.BottomStart),
                    shape = MaterialTheme.shapes.small
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.event),
                        contentDescription = "Add Task",
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Add new task")
                }
            }

            // Contenido adicional: lista de tareas
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos en la columna
            ) {
                Text(
                    text = "Tasks",
                    style = MaterialTheme.typography.headlineMedium // Aumenta el tamaño de la fuente
                )
                Text(
                    text = "To do list",
                    style = MaterialTheme.typography.bodyLarge // Estilo normal para el texto secundario
                )
            }
            Column(modifier = Modifier.padding(16.dp)) {
                // Lista de tareas con divisores
                TaskItem(taskTitle = "Task 1", isComplete = true, onClick = {})
                HorizontalDivider(thickness = 1.dp, color = Color.Gray)
                TaskItem(taskTitle = "Task 2", isComplete = true, onClick = {})
                HorizontalDivider(thickness = 1.dp, color = Color.Gray)
                TaskItem(taskTitle = "Task 3", isComplete = false, onClick = {})
                Spacer(modifier = Modifier.height(16.dp))

                // Botón para ver todas las tareas, centrado
                Button(
                    onClick = { /* Acción para ver todas las tareas */ },
                    modifier = Modifier.align(Alignment.CenterHorizontally) // Centrado
                ) {
                    Text(text = "View all tasks")
                }
            }
        }
    }
}

@Composable
fun TaskItem(taskTitle: String, isComplete: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen simple para las tareas
        Image(
            painter = painterResource(id = R.drawable.ic_placeholder),
            contentDescription = "Icono de tarea",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = taskTitle, style = MaterialTheme.typography.bodyLarge)
            Text(text = "Description", style = MaterialTheme.typography.bodySmall)
        }

        Spacer(modifier = Modifier.width(16.dp))

        // Botón "Complete" o "Not Complete" sin color personalizado
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(text = if (isComplete) "Complete" else "Not Complete") // Color predeterminado
        }
    }
}

// Composable del BottomNavigationBar
@Composable
fun BottomNavigationBar(
    onCalendarClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "To do list") },
            label = { Text("To do list") },
            selected = selectedItem == 0,
            onClick = { selectedItem = 0 }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.CalendarToday, contentDescription = "Calendar") },
            label = { Text("Calendar") },
            selected = selectedItem == 1,
            onClick = {
                selectedItem = 1
                onCalendarClick()
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = selectedItem == 2,
            onClick = {
                selectedItem = 2
                onProfileClick()
            }
        )
    }
}

// Este preview permite visualizar cómo se verá la pantalla
@Preview(showBackground = true)
@Composable
fun PreviewToDoListScreen() {
    ToDoListScreenContent(
        onAddTaskClick = { /* Acción al hacer clic en "Add new task" */ },
        onCalendarClick = { /* Acción al hacer clic en el ícono del calendario */ },
        onProfileClick = { /* Acción al hacer clic en el ícono de perfil */ }
    )
}