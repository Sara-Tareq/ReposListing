# ReposListing

This app is written in Kotlin

For the app architecture I used the android architecture components, following this documentation :
https://developer.android.com/jetpack/docs/guide

![Image of architecture](https://developer.android.com/topic/libraries/architecture/images/final-architecture.png)

The app is loading the saved data in the database firstly if exists, then calling the service upon recieving the response the app is updating the saved data.

For the database I used ROOM database and for the webservice call I used Retrofit for the network call and Moshi for the Json parsing
