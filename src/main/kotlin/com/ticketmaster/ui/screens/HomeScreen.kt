import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.lazy.LazyColumn;
import androidx.compose.foundation.lazy.items;
import androidx.compose.material.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.dp;
import androidx.compose.ui.tooling.preview.Preview;
import androidx.compose.material.TextField;

data class Event(val name: String, val date: String, val location: String);

@Composable
fun HomeScreen() {
    val events = listOf(
        Event("Concert A", "2026-02-18", "Location A"),
        Event("Concert B", "2026-02-19", "Location B"),
        Event("Concert C", "2026-02-20", "Location C")
    )
    var searchQuery by remember { mutableStateOf("") }

    Column(Modifier.padding(16.dp)) {
        TextField(value = searchQuery, onValueChange = { searchQuery = it }, label = { Text("Search events") })

        LazyColumn {
            items(events.filter { it.name.contains(searchQuery, ignoreCase = true) }) { event ->
                EventCard(event)
            }
        }
    }
}

@Composable
fun EventCard(event: Event) {
    Card(Modifier.padding(vertical = 8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.name, style = MaterialTheme.typography.h6)
            Text(text = event.date, style = MaterialTheme.typography.body2)
            Text(text = event.location, style = MaterialTheme.typography.body2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}