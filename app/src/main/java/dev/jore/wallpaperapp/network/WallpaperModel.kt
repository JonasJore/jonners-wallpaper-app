package dev.jore.wallpaperapp.network

data class WallpaperModel(
    val data: WallpaperChildren
)

data class WallpaperChildren(
    val children: List<WallpaperItem>
)

data class WallpaperItem(
    val data: WallpaperData
)

data class WallpaperData(
    val thumbnail: String,
    val subreddit: String,
    val url: String
)