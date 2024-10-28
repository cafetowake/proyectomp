package proyecto_moviles.uvg.edu.gt.presentacion.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import proyecto_moviles.uvg.edu.gt.Calendar.CalendarRoute
import proyecto_moviles.uvg.edu.gt.Profile.ProfileRoute
import proyecto_moviles.uvg.edu.gt.ToDoList.ToDoListRoute
import java.util.Locale

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController = navController, startDestination = Screen.ToDoListScreen.route) {
        composable(Screen.ToDoListScreen.route) {
            ToDoListRoute()
        }
        composable(Screen.CalendarScreen.route) {
            CalendarRoute()
        }
        composable(Screen.ProfileScreen.route) {
            ProfileRoute()
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        val items = listOf(
            Screen.ToDoListScreen,
            Screen.CalendarScreen,
            Screen.ProfileScreen
        )
        items.forEach { screen ->
            NavigationBarItem(
                icon = {
                    when (screen.route) {
                        "to do list" -> Icon(Icons.AutoMirrored.Filled.List, contentDescription = "List")
                        "calendar" -> Icon(Icons.Outlined.CalendarToday, contentDescription = "Calendar")
                        "profile" -> Icon(Icons.Outlined.Person, contentDescription = "Profile")
                    }
                },
                label = {
                    Text(screen.route.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.getDefault()
                        ) else it.toString()
                    })
                },
                selected = false,
                onClick = {
                    navController.navigate(screen.route)
                }
            )
        }
    }
}
