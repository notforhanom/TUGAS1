package com.example.rizzkyy.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rizzkyy.model.anime
import com.example.rizzkyy.ui.theme.RizzkyyTheme
import com.example.rizzkyy.R

@Composable
fun listanime1(
    anime1: anime,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.clickable {
            onItemClicked(anime1.id)
        }
    ) {
        Image(
            painter = painterResource(id = anime1.photo),
            contentDescription = anime1.judul, modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Text(
            text = anime1.judul,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
        Text(
            text = anime1.studio,
            color = MaterialTheme.colorScheme.primary,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.width(80.dp),
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun listanime1priview() {
    RizzkyyTheme {
        listanime1(
            anime1 = anime(1, "one piece", "20 Oktober 1999", "Action, Adventure, Comedy, Super Power","Toei Animation", R.drawable.onepiece),
            onItemClicked = { animeId ->
                println("anime Id : $animeId")
            }
        )
    }
}