# DomainProperties

Sample Application that displays list of rental properties and properties for buyers from Domain
server.

The key focus of this application is following the Clean architecture using MVVM and the best
practices in handling interaction between views and data.
Views are designed and implemented using composeUI and Compose Navigation. Other tech stacks include
Coroutines, Retrofit, HILT for DI, mockk, JUnit4 and is 100% Kotlin; no fragments.

# Screenshots

<table style="width:100%">
  <tr>
    <td><img src="https://github.com/ravimhzn/DomainProperties/blob/main/images/rental_property.png" width="250"></td>
    <td><img src="https://github.com/ravimhzn/DomainProperties/blob/main/images/buyer_property.png" width="250"></td>
  </tr>
</table>

## Some Key Features

- **Clean Architecture**: The foundation of the app is built on the principles of clean
  architecture, ensuring separation of concerns and maintainability.
- **ComposeUI**: Experience a modern UI designed with Jetpack Compose.
- **ViewModel**: Leverage the power of data-driven UI with the ViewModel architecture component.
- **Hilt**: Dependency injection made simple and efficient with Hilt.
- **Retrofit**: Network operations are seamlessly handled by Retrofit along with CoroutineLibrary
- **Coroutine**: Handles background task such as Network call

## Todo

* Global Error/ Loading handling (Architecture is setup - UI pending)

## Terminal Commands:

```aidl
./gradlew clean build (Build) 
./gradlew clean test (UnitTest)
```

## Developed By

RAVI MAHARJAN





