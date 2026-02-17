package com.ticketmaster.models

data class CartItem(
    val ticket: Ticket,
    var quantity: Int
) {
    val subtotal: Double
        get() = ticket.pricePerTicket * quantity
}