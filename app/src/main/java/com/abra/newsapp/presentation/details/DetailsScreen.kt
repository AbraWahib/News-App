package com.abra.newsapp.presentation.details

import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.abra.newsapp.domain.model.Article
import com.abra.newsapp.util.Dimens

@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailsEvents) -> Unit,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    fun onEvent(events: DetailsEvents) {
        when (events) {
            DetailsEvents.BookmarkEvent -> event(DetailsEvents.SaveArticleEvent)
            DetailsEvents.BrowseEvent -> {
                Intent(Intent.ACTION_VIEW).also {
                    it.data = article.url.toUri()
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            }
            DetailsEvents.NavigateUpEvent -> navigateUp
            DetailsEvents.SaveArticleEvent -> {}
            DetailsEvents.ShareArticleEvent -> {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            }
        }
    }

    Scaffold(
        modifier = modifier.fillMaxWidth(), topBar = {
            DetailsTopAppBar(event = {onEvent(it)})
        }) {
        LazyColumn(
            contentPadding = PaddingValues(
                top = it.calculateTopPadding(),
                start = Dimens.MediumPadding1,
                end = Dimens.MediumPadding1
            )
        ) {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context).data(article.urlToImage).build(),
                    contentDescription = "Article Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                        .height(240.dp),

                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
                Text(
                    text = article.title, style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    ), color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(Dimens.MediumPadding1))
                Text(
                    text = article.content,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }

}



