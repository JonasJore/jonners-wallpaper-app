package dev.jore.wallpaperapp.wallpapers

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.jore.wallpaperapp.network.WallpaperModel
import kotlinx.coroutines.launch

class WallpaperViewModel : ViewModel() {
    private val repository = WallpaperRepository()

    var fetchedWallpapers: MutableState<WallpaperModel?> = mutableStateOf(null)
        private set

    fun fetchWallpapers() {
        viewModelScope.launch {
            try {
                val response = repository.getWallpapers()
                fetchedWallpapers.value = response
            } catch (err: Exception) {
                Log.e("error fetching wallpapers", err.toString())
            }
        }
    }
}