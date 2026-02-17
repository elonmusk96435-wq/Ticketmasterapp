data class CartItem(val ticket: String, val quantity: Int) {
    val subtotal: Double
        get() = ticketPrice * quantity
}