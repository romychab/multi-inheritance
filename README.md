# A fun approach to multi-inheritance in Kotlin using Marker Interfaces

This repository contains a simple one-screen Android application that demonstrates
a creative way to simulate multiple inheritance in Kotlin (also applicable to Java).

The core idea is to use marker interfaces to modularize and compose functionality.
Each interface provides a specific feature along with logic, properties, and even
internal state, making it easy to mix and match behaviors in your ViewModel.

Here’s an example:

```kotlin
class CustomViewModel : AbstractViewModel(),
    // 1) WithStateLoader handles state loading automatically
    //    and provides a ready-to-use stateFlow property
    WithStateLoader<ScreenState>,
    // 2) WithCustomViewModelScope overrides viewModelScope
    //    adding a custom CoroutineExceptionHandler
    WithCustomViewModelScope,     // handles errors automatically
    // 3) WithInitCallback provides an onInitialized() callback
    //    as a counterpart to onCleared()
    WithInitCallback {

    // ... your ViewModel logic here
        
}
```

Checkout [this package](app/src/main/java/com/uandcode/inheritance/presentation/base) for more details.
