package proyecto_moviles.uvg.edu.gt.Calendar

import android.widget.CalendarView
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import proyecto_moviles.uvg.edu.gt.presentacion.mainFlow.Calendar.CalendarViewModel
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CalendarRoute(
    onNavigationBack: ( ) -> Unit,
    onNavigateToToDo: ( ) -> Unit,
    onNavigateToProfile: ( ) -> Unit,
    onNavigateToHome: ( ) -> Unit,
    viewModel: CalendarViewModel = viewModel(factory = CalendarViewModel.Factory)
) {
    val state = viewModel.state.collectAsState()

    CalendarScreen(
        state = state,
        onNavigationBack = onNavigationBack,
        onNavigateToToDo = onNavigateToToDo,
        onNavigateToProfile = onNavigateToProfile,
        onNavigateToHome = onNavigateToHome
    )
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen( navController: NavController ,onNavigateToToDo: () -> Unit, onNavigateToProfile: () -> Unit, onNavigateToHome: () -> Unit) {
    var selectedDate by remember { mutableStateOf("") }

    val formatter = SimpleDateFormat("EEE, MMM dd", Locale.getDefault())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calendar") },
                navigationIcon = {
                    IconButton(onClick = onNavigationBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.surface)
            ) {

                AnimatedContent(
                    targetState = selectedDate,
                    transitionSpec = {
                        (fadeIn(animationSpec = tween(300)) + slideInVertically()).togetherWith(
                            fadeOut(animationSpec = tween(300)) + slideOutVertically()
                        )
                    }, label = ""
                ) { targetDate ->
                    Text(
                        text = targetDate.ifEmpty { "Mon, Aug 17" },
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    ),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    AndroidView(
                        factory = { CalendarView(it).apply {
                            setOnDateChangeListener { _, year, month, dayOfMonth ->
                                val calendar = Calendar.getInstance()
                                calendar.set(year, month, dayOfMonth)
                                selectedDate = formatter.format(calendar.time)
                            }
                        }},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }

                AnimatedVisibility(
                    visible = selectedDate.isNotEmpty(),
                    enter = fadeIn() + expandVertically(),
                    exit = fadeOut() + shrinkVertically()
                ) {
                    EventList(
                        events = listOf(
                            "Project 4" to "Task: Hello World",
                            "Math exam" to "Study"
                        )
                    )
                }
            }
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.AutoMirrored.Filled.List,
                            contentDescription = "To do list"
                        )
                    },
                    label = { Text("To do list") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.CalendarToday, contentDescription = "Calendar") },
                    label = { Text("Calendar") },
                    selected = true,
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
    )
}

@Composable
fun EventItem(icon: androidx.compose.ui.graphics.vector.ImageVector, title: String, description: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun EventList(events: List<Pair<String, String>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        events.forEach { event ->
            EventItem(icon = Icons.Default.Notifications, title = event.first, description = event.second)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

