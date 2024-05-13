package com.example.rizzkyy.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrowseGallery
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Topic
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rizzkyy.navigation.navigationitem
import com.example.rizzkyy.R
import com.example.rizzkyy.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun app(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "list anime trending") },
                actions = {
//                    IconButton(onClick = { shareItem(context) }) {
////                        Icon(
////                            imageVector = Icons.Default.Share, contentDescription = stringResource(
////                                id = R.string.menu_share
////                            )
//                        )
//                    }
                }
            )
        },
        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }

            composable(Screen.Gallery.route) {
                GalleryScreen()
            }
            composable(Screen.About.route) {
                about()
            }


            composable(
                Screen.Detail.route + "/{animeId}",
                arguments = listOf(navArgument("animeId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailanimeScreen(
                    navController = navController,
                    animeId = navBackStackEntry.arguments?.getInt("animeId")
                )
            }
        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            navigationitem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            navigationitem(
                title = stringResource(id = R.string.menu_gallery),
                icon = Icons.Default.BrowseGallery,
                screen = Screen.Gallery
            ),
            navigationitem(
                title = stringResource(id = R.string.menu_about),
                icon = Icons.Default.ChildCare,
                screen = Screen.About
            ),
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun apppriview() {
    app()
}