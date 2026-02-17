package com.ticketmaster.models

data class Event(
    val id: String,
    val name: String,
    val artist: String,
    val date: String,
    val location: String,
    val price: Double,
    val availableTickets: Int
)