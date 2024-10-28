package proyecto_moviles.uvg.edu.gt.presentacion.navigation

sealed class Screen(val route: String){
    object ToDoListScreen :Screen("To do list")
    object CalendarScreen :Screen("Calendar")
    object ProfileScreen :Screen("Profile")
}