package dev.jore.wallpaperapp.ui.composable.screens

import android.content.Context
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import dev.jore.wallpaperapp.wallpapers.WallpaperViewModel
import no.softsolutionsbyjore.jonnerswallpaperapp.R

@Composable
fun HomeScreen(
    wallpaperViewModel: WallpaperViewModel,
    paddingValues: PaddingValues
) {
    val wallpapers by remember {
        mutableStateOf(wallpaperViewModel.fetchedWallpapers)
    }

    wallpaperViewModel.fetchWallpapers()

    val context = LocalContext.current

    wallpapers.value?.let { items ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            itemsIndexed(items.data.children) { index, wallpaper ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            openSecureBrowser(context, wallpaper.data.url)
                        },
                ) {
                    AsyncImage(
                        model = wallpaper.data.thumbnail,
                        contentDescription = "Character picture",
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(8.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopCenter,
                        error = painterResource(id = R.drawable.ic_launcher_foreground),
                    )
                }
            }
        }
    } ?: run {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(modifier = Modifier.padding(6.dp))
        }
    }

}

fun openSecureBrowser(context: Context, url: String) {
    val customTabsIntent = CustomTabsIntent.Builder()
        .setShowTitle(true)
        .build()
    customTabsIntent.launchUrl(context, url.toUri())
}