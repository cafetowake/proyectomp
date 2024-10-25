package proyecto_moviles.uvg.edu.gt.New_Task

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskScreen() {
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("New Task") },
                navigationIcon = {
                    IconButton(onClick = { /* Acción al presionar botón de volver */ }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Imagen
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Task icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
                contentScale = ContentScale.Fit
            )

            // Nombre de la tarea
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Task name") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(Icons.Filled.Edit, contentDescription = "Edit task name")
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Descripción de la tarea
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Task description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                trailingIcon = {
                    Icon(Icons.Filled.Edit, contentDescription = "Edit task description")
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo de fecha de inicio
            DatePickerField(
                label = "Start date",
                selectedDate = startDate,
                onDateSelected = { startDate = it },
                context = context
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Campo de fecha de fin
            DatePickerField(
                label = "End date",
                selectedDate = endDate,
                onDateSelected = { endDate = it },
                context = context
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de guardar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { /* Acción para guardar tarea */ }
                ) {
                    Text("Save")
                }
            }
        }
    }
}

@Composable
fun DatePickerField(
    label: String,
    selectedDate: String,
    onDateSelected: (String) -> Unit,
    context: Context
) {
    OutlinedTextField(
        value = selectedDate,
        onValueChange = { /* No hace nada porque es solo lectura */ },
        label = { Text(label) },
        placeholder = { Text("mm/dd/yyyy") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        trailingIcon = {
            IconButton(onClick = {
                showDatePicker(context, onDateSelected)
            }) {
                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "Select $label")
            }
        },
        readOnly = true
    )
}

fun showDatePicker(context: Context, onDateSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = "${selectedMonth + 1}/$selectedDay/$selectedYear"
            onDateSelected(selectedDate)
        },
        year, month, day
    ).show()
}

@Preview(showBackground = true)
@Composable
fun NewTaskView() {
    NewTaskScreen()
}
