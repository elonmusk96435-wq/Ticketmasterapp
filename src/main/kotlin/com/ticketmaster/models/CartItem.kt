package com.ticketmaster.models

data class CartItem(
    val ticket: Ticket,
    var quantity: Int = 1
) {
    val subtotal: Double
        get() = ticket.pricePerTicket * quantity
}