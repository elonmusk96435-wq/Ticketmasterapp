# Ticketmaster App

A fake Ticketmaster Android app built with Kotlin, Jetpack Compose, and MVVM architecture.

## Features

- 🎫 Browse and search events
- 🔍 View event details and seat availability
- 🛒 Add tickets to cart
- 💳 Simulated checkout flow
- 🎨 Modern UI with Jetpack Compose

## Tech Stack

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Architecture:** MVVM
- **Dependency Injection:** Hilt
- **Networking:** Retrofit + OkHttp
- **Async:** Coroutines

## Project Structure

```
app/
├── data/
│   ├── api/          # API service definitions
│   ├── model/        # Data models
│   └── repository/   # Repository layer
├── ui/
│   ├── screens/      # Compose screens
│   └── theme/        # App theming
├── viewmodel/        # MVVM ViewModels
└── utils/            # Utilities
```

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Build and run on an emulator or device

## Future Enhancements

- [ ] User authentication
- [ ] Payment integration
- [ ] Order history
- [ ] Favorites
- [ ] Reviews and ratings
