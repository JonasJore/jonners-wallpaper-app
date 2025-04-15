package dev.jore.wallpaperapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.jore.wallpaperapp.ui.composable.MainTopBar
import dev.jore.wallpaperapp.ui.composable.screens.HomeScreen
import dev.jore.wallpaperapp.ui.theme.WallpaperAppTheme
import dev.jore.wallpaperapp.wallpapers.WallpaperViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val wallpapersViewModel: WallpaperViewModel by viewModels()
        enableEdgeToEdge()
        setContent {
            WallpaperAppTheme {
                ComposeApp(wallpapersViewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeApp(wallpaperViewModel: WallpaperViewModel) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            MainTopBar(
                title = "jonners' wallpaper app",
                icon = Icons.AutoMirrored.Filled.ArrowBack
            ) {
                navController.navigate(Route.HOME)
            }
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primary,
                modifier = Modifier.background(MaterialTheme.colorScheme.background)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { navController.navigate(Route.HOME) }) {
                        Icon(imageVector = Icons.Filled.Home, contentDescription = "Home")
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController = navController, startDestination = Route.HOME) {
            composable(Route.HOME) {
                HomeScreen(
                    wallpaperViewModel = wallpaperViewModel,
                    paddingValues = innerPadding
                )
            }
        }
    }
}

object Route {
    const val HOME = "home"
}