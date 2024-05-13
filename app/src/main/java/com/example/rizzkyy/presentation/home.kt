package com.example.rizzkyy.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rizzkyy.data.DummyData
import com.example.rizzkyy.model.anime
import com.example.rizzkyy.presentation.component.listanime1
import com.example.rizzkyy.presentation.component.listanime2
import com.example.rizzkyy.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    animes: List<anime> = DummyData.listanime,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                items(animes, key = { it.id }) {
                    listanime1(anime1 = it) { animeId ->
                        navController.navigate(Screen.Detail.route + "/$animeId")
                    }
                }
            }
        }
        items(animes, key = { it.id }) {
            listanime2(anime2 = it, modifier = Modifier.padding(horizontal = 16.dp)){ animeId ->
                navController.navigate(Screen.Detail.route + "/$animeId")
            }
        }
    }
}