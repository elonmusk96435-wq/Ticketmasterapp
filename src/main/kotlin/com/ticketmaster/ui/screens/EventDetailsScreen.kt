package com.ticketmaster.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ticketmaster.models.Event
import com.ticketmaster.models.Ticket
import com.ticketmaster.viewmodel.CartViewModel
import com.ticketmaster.viewmodel.EventViewModel

@Composable
fun EventDetailsScreen(
    viewModel: EventViewModel,
    cartViewModel: CartViewModel,
    onBackClick: () -> Unit
) {
    val selectedEvent by viewModel.selectedEvent.collectAsState()
    var quantity by remember { mutableStateOf(1) }

    selectedEvent?.let { event ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TopAppBar(
                title = { Text("Event Details") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(event.name, style = MaterialTheme.typography.h5)
                    Text("Date: ${event.date}")
                    Text("Location: ${event.location}")
                    Text("Available Tickets: ${event.availableTickets}")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Select Quantity", style = MaterialTheme.typography.h6)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { if (quantity > 1) quantity-- }) {
                    Text("-")
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(quantity.toString(), style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { if (quantity < event.availableTickets) quantity++ }) {
                    Text("+")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("Price per ticket: $49.99")
            Text("Total: ${49.99 * quantity}", style = MaterialTheme.typography.h6)

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    val ticket = Ticket(
                        id = event.id,
                        eventId = event.id,
                        eventTitle = event.name,
                        quantity = quantity,
                        pricePerTicket = 49.99,
                        date = event.date,
                        location = event.location
                    )
                    cartViewModel.addToCart(ticket, quantity)
                    onBackClick()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text("Add to Cart")
            }
        }
    }
}