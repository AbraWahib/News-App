package com.abra.newsapp.presentation.newsNavigator

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abra.newsapp.ui.theme.NewsAppTheme
import com.abra.newsapp.util.Dimens

@Composable
fun NewsBottomNavigation(
    items: List<BottomNavigationItem>,
    selectedItem: Int,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        tonalElevation = 10.dp,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = index == selectedItem,
                onClick = { onItemClick(index) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.text
                        )
                        Spacer(modifier = Modifier.height(Dimens.ExtraSmallPadding2))
                        Text(text = item.text, style = MaterialTheme.typography.labelSmall)
                    }
                }
            )
        }
    }
}

data class BottomNavigationItem(
    val icon: ImageVector,
    val text: String
)

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun NewsBottomPrev() {
    NewsAppTheme {
        Scaffold(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background),
            bottomBar = { NewsBottomNavigation(
                items = listOf(
                    BottomNavigationItem(
                        icon = Icons.Outlined.Home,
                        text = "Home"
                    ),
                    BottomNavigationItem(
                        icon = Icons.Outlined.Search,
                        text = "Search"
                    ),
                    BottomNavigationItem(
                        icon = Icons.Outlined.BookmarkBorder,
                        text = "Bookmark"
                    )
                ),
                selectedItem = 1,
                onItemClick = {}
            ) }
        ) {
            Column(modifier = Modifier.padding(it)) {

            }
        }
    }
}