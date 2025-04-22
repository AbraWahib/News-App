package com.abra.newsapp.presentation.details

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Public
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopAppBar(
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onBrowseClick: () -> Unit,
    onBookmarkClick: () -> Unit
) {
    TopAppBar(
        title = {},
        modifier = Modifier
            .fillMaxWidth(),
        navigationIcon = {
            IconButton(
                onClick = onBackClick
            ) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Navigate back")
            }
        },
        actions = {
            IconButton(
                onClick = onBookmarkClick
            ) {
                Icon(imageVector = Icons.Outlined.BookmarkBorder, contentDescription = "Bookmark")
            }
            IconButton(
                onClick = onShareClick
            ) {
                Icon(imageVector = Icons.Outlined.Share, contentDescription = "Share")
            }
            IconButton(
                onClick = onBrowseClick
            ) {
                Icon(imageVector = Icons.Outlined.Public, contentDescription = "Browse")
            }
        }
    )
}



