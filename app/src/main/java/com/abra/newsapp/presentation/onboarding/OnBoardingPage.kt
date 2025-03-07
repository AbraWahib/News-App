package com.abra.newsapp.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abra.newsapp.R
import com.abra.newsapp.ui.theme.NewsAppTheme

@Composable
fun OnBoardingPage(page: Page, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Image(
            painter = painterResource(id = page.image),
            contentDescription = page.title,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            contentScale = ContentScale.Fit
        )
        Text(
            text = page.title,
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = page.description, style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun Prev() {
    NewsAppTheme {
        Surface(modifier = Modifier.background(color = MaterialTheme.colorScheme.background)) {
            OnBoardingPage(pages[0])
        }
    }
}