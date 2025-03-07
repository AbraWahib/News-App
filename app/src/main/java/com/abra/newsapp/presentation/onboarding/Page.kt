package com.abra.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.abra.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "Stay Informed in Real-Time.",
        "Get breaking news alerts and instant updates from around the world. Never miss a moment as stories develop.",
        image = R.drawable.onboarding1
    ),
    Page(
        "Discover Your Interests.",
        "Follow the topics, categories, and sources you love. Our personalized feed makes it easy to explore what matters most to you.",
        image = R.drawable.onboarding2
    ),
    Page(
        "Save & Share Effortlessly.",
        "Bookmark articles to read later, even offline, and share the stories that inspire you with just one tap.",
        image = R.drawable.onboarding3
    ),
)
