package com.ticketmaster.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val events = listOf(
        "Concert A",
        "Concert B",
        "Play C",
        "Exhibition D"
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Event Search", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Search Events") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Event List", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
        events.filter { it.contains(searchQuery, true) }.forEach { event ->
            Text(text = event, modifier = Modifier.padding(4.dp))
        }
    }
}