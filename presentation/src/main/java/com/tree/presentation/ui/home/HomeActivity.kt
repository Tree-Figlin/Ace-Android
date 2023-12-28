package com.tree.presentation.ui.home

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tree.design_system.component.bottombar.AceBottomNavigationBar
import com.tree.presentation.ui.base.BaseActivity
import com.tree.presentation.ui.home.screen.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

enum class MainPage(val value: String) {
    Home("Home"),
    News("News"),
    Event("Event")
}

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
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
                        HomeScreen()
                    }
                    composable(MainPage.News.name) {
                        Box(modifier = Modifier)
                    }
                    composable(MainPage.Event.name) {
                        Box(modifier = Modifier)
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