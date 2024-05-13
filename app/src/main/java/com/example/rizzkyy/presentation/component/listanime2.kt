package com.example.rizzkyy.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rizzkyy.R
import com.example.rizzkyy.model.anime
import com.example.rizzkyy.ui.theme.RizzkyyTheme

@Composable
fun listanime2(
    anime2: anime,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = anime2.photo),
            contentDescription = anime2.judul,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = anime2.judul, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = anime2.studio, color = MaterialTheme.colorScheme.primary)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun listanime2priview() {
    RizzkyyTheme {
        listanime2(
            anime2 = anime(1, "one piece", "20 Oktober 1999", "Action, Adventure, Comedy, Super Power","Toei Animation", R.drawable.onepiece),
            onItemClicked = { animeId ->
                println("anime Id : $animeId")
            }
        )
    }
}