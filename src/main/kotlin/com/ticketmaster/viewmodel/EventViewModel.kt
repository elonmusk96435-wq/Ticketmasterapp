import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventViewModel : ViewModel() {
    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events

    private val _searchResults = MutableStateFlow<List<Event>>(emptyList())
    val searchResults: StateFlow<List<Event>> = _searchResults

    fun fetchEvents() {
        viewModelScope.launch {
            // Simulate fetching events from a repository
            _events.value = repository.getEvents() // Placeholder for actual data source
        }
    }

    fun searchEvents(query: String) {
        _searchResults.value = _events.value.filter { event ->
            event.name.contains(query, ignoreCase = true)
        }
    }
}

data class Event(val id: Int, val name: String, val date: String, val location: String)