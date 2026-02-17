package com.ticketmaster.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.FieldValue
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    var searchQuery by remember { mutableStateOf(TextFieldValue()) }
    var events by remember { mutableStateOf(listOf<Event>()) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        SearchBar(searchQuery) { searchQuery = it }
        Spacer(modifier = Modifier.height(16.dp))
        EventList(events)
    }
}

@Composable
fun SearchBar(query: TextFieldValue, onQueryChanged: (TextFieldValue) -> Unit) {
    TextField(
        value = query,
        onValueChange = onQueryChanged,
        placeholder = { Text("Search events...") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun EventList(events: List<Event>) {
    if (events.isEmpty()) {
        EmptyState()
    } else {
        Column {
            for (event in events) {
                EventCard(event)
            }
        }
    }
}

@Composable
fun EmptyState() {
    Text(text = "No events found", style = MaterialTheme.typography.h6)
}

@Composable
fun EventCard(event: Event) {
    Card(modifier = Modifier.padding(vertical = 8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = event.title, style = MaterialTheme.typography.h6)
            Text(text = "${event.date}")
            Badge(availability = event.availability)
        }
    }
}

@Composable
fun Badge(availability: String) {
    Text(text = availability, modifier = Modifier.padding(4.dp), style = MaterialTheme.typography.body2)
}

data class Event(val title: String, val date: String, val availability: String)

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()  
}