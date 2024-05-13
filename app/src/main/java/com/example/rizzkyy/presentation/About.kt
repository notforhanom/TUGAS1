package com.example.rizzkyy.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rizzkyy.R
import com.example.rizzkyy.model.anime
import com.example.rizzkyy.ui.theme.RizzkyyTheme

@Composable
fun about(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.p),
            contentDescription = "risky"
        )
        Text(
            text = "muh.risky ramadhan\n114202103858@mhs.dinus.ac.id\nUNIVERSITAS DIAN NUSWANTORO\nDESAIN KOMUNIKASI VISUAL" ,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier.width(10000.dp),
            maxLines = 10
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun listaboutpriview() {
    RizzkyyTheme {
        about()
    }
}