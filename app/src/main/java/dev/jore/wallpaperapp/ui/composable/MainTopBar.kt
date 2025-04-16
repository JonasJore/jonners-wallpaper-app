package dev.jore.wallpaperapp.ui.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.primary
    ),
    title: String,
    icon: ImageVector,
    onIconClick: () -> Unit
) {
    TopAppBar(
        colors = colors,
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(
                onClick = onIconClick,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .clickable { onIconClick() }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Menu",
                    tint = Color.Black
                )
            }
        }
    )
}