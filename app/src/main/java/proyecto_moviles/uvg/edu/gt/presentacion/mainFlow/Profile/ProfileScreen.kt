package proyecto_moviles.uvg.edu.gt.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back button click */ }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Profile picture
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "Profile Picture",
                        modifier = Modifier.size(80.dp)
                    )
                }
            }


            Spacer(modifier = Modifier.height(16.dp))
            // Username
            OutlinedTextField(
                value = "Username",
                onValueChange = { /* Handle username change */ },
                label = { Text("Username") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { /* Handle edit username */ }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Edit Username")
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // E-mail
            OutlinedTextField(
                value = "username@gmail.com",
                onValueChange = { /* Handle email change */ },
                label = { Text("E-mail") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { /* Handle edit email */ }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Edit E-mail")
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Password
            OutlinedTextField(
                value = "********",
                onValueChange = { /* Handle password change */ },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { /* Handle edit password */ }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Edit Password")
                    }
                },
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Save button
            Button(
                onClick = { /* Handle save button click */ },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Save")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileView(){
    ProfileScreen()
}
