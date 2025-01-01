# Users List Application

A modern Android application that demonstrates clean architecture, MVVM pattern, and best practices in Android development. The app fetches a list of users from an API and allows marking users as favorites with local persistence.

## Architecture Overview

### Clean Architecture Implementation
The application follows MVVM (Model-View-ViewModel) architecture pattern with clean architecture principles:

- **UI Layer (Presentation)**
  - Composable components
  - State management
  - User interactions

- **ViewModel Layer**
  - Business logic
  - State handling
  - Data transformation

- **Repository Layer**
  - Data coordination
  - Single source of truth
  - Data operations

- **Data Layer**
  - Remote data (API)
  - Local storage (SharedPreferences)

### Key Components

#### 1. UI Layer (Presentation)
- **MainActivity**: Entry point of the application
- **UsersList**: Main composable that displays the list of users
- **UserItem**: Individual user item composable with favorite functionality

#### 2. ViewModel Layer
- **UsersViewModel**: Manages UI state and business logic
  - Handles user data fetching
  - Manages favorite users state
  - Handles error states and loading indicators

#### 3. Repository Layer
- **UsersRepository**: Single source of truth for user data
  - Fetches users from API
  - Coordinates with local storage

#### 4. Data Layer
- **Remote**: API service using Retrofit
- **Local**: SharedPreferences for favorite users persistence

## Technical Stack

- **UI**: Jetpack Compose
- **Dependency Injection**: Hilt
- **Networking**: Retrofit
- **JSON Parsing**: Gson
- **Asynchronous Programming**: Coroutines & Flow
- **Local Storage**: SharedPreferences
- **Architecture Components**: ViewModel, StateFlow

## Features

1. **User List Display**
   - Fetches users from remote API
   - Displays user name and email
   - Handles loading and error states

2. **Favorite Users**
   - Toggle favorite status for users
   - Persists favorite status locally
   - Visual indication of favorite status

3. **Error Handling**
   - Graceful error display
   - Loading state indication
   - Network error handling

## Project Structure
```
com.wahid.tawuniya/
├── composables/
│ ├── UserItem.kt # Individual user item UI
│ └── UsersList.kt # List of users UI
├── data/
│ ├── remote/
│ │ └── ApiService.kt # API interface
│ └── UserPreferences.kt # Local storage management
├── di/
│ ├── NetworkModule.kt # Network dependency injection
│ └── SharedPreferencesModule.kt # SharedPreferences DI
├── models/
│ ├── User.kt # User data model
│ └── Address.kt # Address data model
├── repositories/
│ └── UsersRepository.kt # Data repository
├── viewmodels/
│ └── UsersViewModel.kt # UI state management
└── MainActivity.kt # Main entry point
```


## Potential Enhancements

### 1. Data Layer Improvements
- Implement Room database for robust local storage
- Add offline-first architecture
- Implement data synchronization strategy
- Add data mapping between layers
- Implement caching mechanism

### 2. UI/UX Enhancements
- Add pull-to-refresh functionality
- Implement search/filter capabilities
- Add user details screen
- Implement dark/light theme support
- Add animations and transitions
- Implement list pagination

### 3. Architecture Improvements
- Add domain layer with use cases
- Implement clean architecture boundaries
- Add data mappers between layers
- Implement repository pattern with multiple data sources
- Add proper error handling with sealed classes

### 4. Testing
- Add unit tests for ViewModel and Repository
- Implement UI tests using Compose testing
- Add integration tests
- Implement end-to-end testing
- Add performance testing

### 5. Performance Optimizations
- Implement pagination for large lists
- Add image caching
- Optimize database queries
- Implement efficient list rendering
- Add memory management optimizations

### 6. Security
- Implement data encryption
- Add API key security
- Implement secure storage for sensitive data
- Add SSL pinning
- Implement proper authentication

## Dependencies
