package dev.jore.wallpaperapp.wallpapers

import dev.jore.wallpaperapp.RetrofitInstance
import dev.jore.wallpaperapp.network.WallpaperModel

class WallpaperRepository {
    private val wallpaperApi = RetrofitInstance.wallpaperApi

    suspend fun getWallpapers(): WallpaperModel {
        return wallpaperApi.getWallpapers()
    }
}