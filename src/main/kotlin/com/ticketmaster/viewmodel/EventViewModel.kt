package com.ticketmaster.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ticketmaster.models.Event
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {
    private val _eventList = MutableStateFlow<List<Event>>(emptyList())
    val eventList: StateFlow<List<Event>> = _eventList

    private val _selectedEvent = MutableStateFlow<Event?>(null)
    val selectedEvent: StateFlow<Event?> = _selectedEvent

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    init {
        loadEvents()
    }

    private fun loadEvents() {
        viewModelScope.launch {
            val mockEvents = listOf(
                Event(id = "1", name = "Taylor Swift Concert", date = "2026-03-15", location = "Madison Square Garden"),
                Event(id = "2", name = "NBA Finals Game 1", date = "2026-06-01", location = "Chase Center"),
                Event(id = "3", name = "Coachella 2026", date = "2026-04-10", location = "Indio, California"),
                Event(id = "4", name = "Coldplay Tour", date = "2026-05-20", location = "SoFi Stadium"),
                Event(id = "5", name = "Broadway: Hamilton", date = "2026-02-28", location = "Richard Rodgers Theatre")
            )
            _eventList.value = mockEvents
        }
    }

    fun searchEvents(query: String) {
        _searchQuery.value = query
        viewModelScope.launch {
            val filtered = if (query.isEmpty()) {
                _eventList.value
            } else {
                _eventList.value.filter { 
                    it.name.contains(query, ignoreCase = true) ||
                    it.location.contains(query, ignoreCase = true)
                }
            }
            _eventList.value = filtered
        }
    }

    fun selectEvent(event: Event) {
        _selectedEvent.value = event
    }

    fun clearSelection() {
        _selectedEvent.value = null
    }
}