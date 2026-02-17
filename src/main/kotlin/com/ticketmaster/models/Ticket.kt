package com.ticketmaster.models

data class Ticket(
    val id: String,
    val eventId: String,
    val eventTitle: String,
    val quantity: Int,
    val pricePerTicket: Double,
    val date: String,
    val location: String
)