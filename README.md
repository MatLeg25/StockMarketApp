# StockMarketApp
Project based on tutorial [https://www.youtube.com/watch?v=uLs2FxFSWU4].

The app displays a list of company from market. Stock data is provided by API: https://www.alphavantage.co/ <br />
On the details screen, the user can find more information about the selected company and the stock price from the last working day. <br />
The app manages the cache using RoomDB.

## Screenshots:
- CompanyListings screen: <br />
![image](https://github.com/MatLeg25/StockMarketApp/assets/70913892/ae7ff60b-40bb-4348-a55e-615cc182fa52)

- CompanyInfo screen: <br />
![image](https://github.com/MatLeg25/StockMarketApp/assets/70913892/1225edc5-468e-4174-b9e6-c27e158b1fc3)

## App overview (video)
[StockMarketApp-overview.webm](https://github.com/MatLeg25/StockMarketApp/assets/70913892/971568b2-9f4e-4a68-a10f-81227cb768a4)

## Tech stack:
- Android
- Kotlin, Coroutines, Flow
- MVVM
- DI with Dagger-Hilt
- RoomDB
- Retrofit, Moshi, okhttp3
- Jetpack Compose
- Compose Navigation by [io.github.raamcosta.compose-destinations:core:1.1.2-beta]
- OpenCSV
