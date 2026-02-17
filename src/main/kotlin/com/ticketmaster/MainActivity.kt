package com.ticketmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.ticketmaster.ui.theme.TicketmasterTheme
import com.ticketmaster.viewmodel.CartViewModel
import com.ticketmaster.viewmodel.EventViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketmasterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TicketmasterApp()
                }
            }
        }
    }
}

sealed class Screen {
    object Home : Screen()
    object EventDetails : Screen()
    object Cart : Screen()
    object Checkout : Screen()
}

@Composable
fun TicketmasterApp() {
    val currentScreen = remember { mutableStateOf<Screen>(Screen.Home) }
    val eventViewModel = remember { EventViewModel() }
    val cartViewModel = remember { CartViewModel() }

    when (currentScreen.value) {
        Screen.Home -> {
            androidx.compose.material.Text("Home Screen")
        }
        Screen.EventDetails -> {
            androidx.compose.material.Text("Event Details Screen")
        }
        Screen.Cart -> {
            androidx.compose.material.Text("Cart Screen")
        }
        Screen.Checkout -> {
            androidx.compose.material.Text("Checkout Screen")
        }
    }
}