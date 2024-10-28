package proyecto_moviles.uvg.edu.gt.Create_Proyecto


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CreateProjectScreenContent() {
    var projectNameCps by remember { mutableStateOf("") }
    var descriptionCps by remember { mutableStateOf("") }
    var inviteEmailCps by remember { mutableStateOf("") }
    var generalAccessCps by remember { mutableStateOf("Private") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image Placeholder
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            // Placeholder para la imagen
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    imageVector = Icons.Filled.ArrowDropUp,
                    contentDescription = "Image Placeholder",
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "1st", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            // Project name
            Text(
                text = "Project Name:",
                fontSize = 17.sp,
                modifier = Modifier.align(Alignment.Start)
            )

            TextField(
                value = projectNameCps,
                onValueChange = { projectNameCps = it },
                label = { Text("Project name") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // General Access
        Text(
            text = "General Access:",
            fontSize = 17.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        var expandedCps by remember { mutableStateOf(false) }
        Box(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = generalAccessCps,
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { expandedCps = true }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropUp,
                            contentDescription = "Dropdown Icon"
                        )
                    }
                }
            )
            DropdownMenu(
                expanded = expandedCps,
                onDismissRequest = { expandedCps = false }
            ) {
                DropdownMenuItem(onClick = {
                    generalAccessCps = "Private"
                    expandedCps = false
                }) {
                    Text("Private")
                }
                DropdownMenuItem(onClick = {
                    generalAccessCps = "Public"
                    expandedCps = false
                }) {
                    Text("Public")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Description
        Text(
            text = "Description:",
            fontSize = 17.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        TextField(
            value = descriptionCps,
            onValueChange = { descriptionCps = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Invite
        Text(
            text = "Invite:",
            fontSize = 17.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = inviteEmailCps,
                onValueChange = { inviteEmailCps = it },
                label = { Text("Invite") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { /* Logic to handle invite */ }) {
                Text("Done")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Create Project Button
        Button(
            onClick = { /* Logic to handle project creation */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create Project")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCreateProjectScreenContent() {
    CreateProjectScreenContent()
}
