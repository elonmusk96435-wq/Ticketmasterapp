package com.ticketmaster.models

data class Event(
    val id: String,
    val name: String,
    val date: String,
    val location: String,
    val availableTickets: Int,
    val description: String = "",
    val imageUrl: String = "",
    val venue: String = "",
    val artist: String = ""
)