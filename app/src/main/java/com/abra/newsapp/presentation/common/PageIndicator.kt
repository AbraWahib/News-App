package com.abra.newsapp.presentation.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.abra.newsapp.ui.theme.Dimens.indicatorSize

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    currentPage: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = selectedColor.copy(alpha = 0.5f)
) {
    repeat(pageCount) { page ->
        Box(
            modifier = modifier
                .padding(4.dp)
                .clip(CircleShape)
                .size(indicatorSize)
                .background(if (currentPage == page) selectedColor else unselectedColor)


        )
    }
}