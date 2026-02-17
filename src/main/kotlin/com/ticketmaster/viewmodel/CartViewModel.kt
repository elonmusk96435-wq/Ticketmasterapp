package com.ticketmaster.viewmodel

import androidx.lifecycle.ViewModel
import com.ticketmaster.models.CartItem
import com.ticketmaster.models.Ticket
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    private val _totalPrice = MutableStateFlow(0.0)
    val totalPrice: StateFlow<Double> = _totalPrice

    fun addToCart(ticket: Ticket, quantity: Int = 1) {
        val currentCart = _cartItems.value.toMutableList()
        val existingItem = currentCart.find { it.ticket.id == ticket.id }

        if (existingItem != null) {
            existingItem.quantity += quantity
        } else {
            currentCart.add(CartItem(ticket, quantity))
        }

        _cartItems.value = currentCart
        updateTotalPrice()
    }

    fun removeFromCart(ticketId: String) {
        val currentCart = _cartItems.value.toMutableList()
        currentCart.removeAll { it.ticket.id == ticketId }
        _cartItems.value = currentCart
        updateTotalPrice()
    }

    fun updateQuantity(ticketId: String, quantity: Int) {
        val currentCart = _cartItems.value.toMutableList()
        val item = currentCart.find { it.ticket.id == ticketId }
        if (item != null && quantity > 0) {
            item.quantity = quantity
            _cartItems.value = currentCart
            updateTotalPrice()
        }
    }

    fun clearCart() {
        _cartItems.value = emptyList()
        _totalPrice.value = 0.0
    }

    private fun updateTotalPrice() {
        _totalPrice.value = _cartItems.value.sumOf { it.subtotal }
    }
}