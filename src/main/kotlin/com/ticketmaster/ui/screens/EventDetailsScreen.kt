import androidx.compose.foundation.layout.*;
import androidx.compose.material.Button;
import androidx.compose.material.Text;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.remember;
import androidx.compose.runtime.mutableStateOf;
import androidx.compose.runtime.remember;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.dp;

@Composable
fun EventDetailsScreen() {
    // Example event details
    val eventName = "Awesome Event"
    val eventDate = "2026-02-20"
    val eventDescription = "This is an amazing event you don’t want to miss!"
    
    // Ticket quantity state
    val ticketQuantity = remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Event: $eventName")
        Text(text = "Date: $eventDate")
        Text(text = "Description: $eventDescription")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Tickets: ${ticketQuantity.value}")
        Row { 
            Button(onClick = { if (ticketQuantity.value > 1) ticketQuantity.value-- }) {
                Text(text = "-"
            }
            Button(onClick = { ticketQuantity.value++ }) {
                Text(text = "+")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Add to cart logic here */ }) {
            Text(text = "Add to Cart")
        }
    }
}