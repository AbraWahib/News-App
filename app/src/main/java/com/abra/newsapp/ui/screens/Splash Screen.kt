package com.abra.newsapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abra.newsapp.R
import androidx.compose.material3.MaterialTheme.colorScheme

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navigateToMain: () -> Unit) {
    Column(
        modifier = modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_icon),
            contentDescription = "App Icon",
            modifier = Modifier.size(210.dp),
            contentScale = ContentScale.Fit
        )
        LinearProgressIndicator(
            modifier = Modifier
                .width(210.dp)
                .padding(top = 16.dp),
            color = colorScheme.primary
        )
        LaunchedEffect(Unit) {
            kotlinx.coroutines.delay(1750)
            navigateToMain()
        }
    }

}


//@Preview
//@Composable
//private fun SplashPrev() {
//    NewsAppTheme {
//        SplashScreen {}
//    }
//}