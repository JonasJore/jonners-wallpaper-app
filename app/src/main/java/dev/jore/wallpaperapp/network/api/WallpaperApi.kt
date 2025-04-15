package dev.jore.wallpaperapp.network.api

import dev.jore.wallpaperapp.network.WallpaperModel
import retrofit2.http.GET

interface WallpaperApi {
    @GET("wallpapers+wallpaper.json")
    suspend fun getWallpapers(): WallpaperModel
}