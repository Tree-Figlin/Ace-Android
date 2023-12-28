package com.tree.presentation.ui.home

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tree.design_system.component.bottombar.AceBottomNavigationBar
import com.tree.presentation.ui.base.BaseActivity
import com.tree.presentation.ui.home.screen.HomeScreen
import com.tree.presentation.ui.map.screen.MapScreen
import com.tree.presentation.ui.news.screen.NewsScreen
import com.tree.presentation.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint

enum class MainPage(val value: String) {
    Home("Home"),
    News("News"),
    Event("Event")
}

enum class SubPage(val value: String) {
    Map("Map")
}

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    private val mapViewModel by viewModels<MapViewModel>()
    override fun init() {
        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
                    .navigationBarsPadding()
            ) {
                NavHost(
                    navController = navController,
                    startDestination = MainPage.Home.name
                ) {
                    composable(MainPage.Home.name) {
                        HomeScreen(
                            onNewsClick = { navController.navigate(MainPage.News.value) }
                        )
                    }
                    composable(MainPage.News.name) {
                        NewsScreen()
                    }
                    composable(MainPage.Event.name) {

                    }
                    composable(SubPage.Map.name) {
                        MapScreen(
                            navController = navController,
                            viewModel = mapViewModel,
                            onBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
                AceBottomNavigationBar(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    isVisible = currentRoute in MainPage.values().map { it.name },
                    currentRoute = currentRoute ?: "Home",
                    onNewsClick = { navController.navigate(MainPage.News.value) },
                    onHomeClick = { navController.navigate(MainPage.Home.value) },
                    onEventClick = { navController.navigate(MainPage.Event.value) }
                )
            }
        }
    }
}