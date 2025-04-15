package dev.jore.wallpaperapp

import dev.jore.wallpaperapp.network.api.WallpaperApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.reddit.com/r/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val wallpaperApi: WallpaperApi by lazy {
        retrofit.create(WallpaperApi::class.java)
    }
}