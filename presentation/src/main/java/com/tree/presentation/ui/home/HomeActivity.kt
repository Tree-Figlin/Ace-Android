package com.tree.presentation.ui.home

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tree.design_system.component.bottombar.AceBottomNavigationBar
import com.tree.presentation.BuildConfig
import com.tree.presentation.ui.base.BaseActivity
import com.tree.presentation.ui.home.screen.HomeScreen
import com.tree.presentation.ui.news.screen.NewsScreen
import com.tree.presentation.viewmodel.NewsViewModel
import com.tree.presentation.viewmodel.util.Event
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class MainPage(val value: String) {
    Home("Home"),
    News("News"),
    Event("Event")
}

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    private val newsViewModel by viewModels<NewsViewModel>()

    override fun init() {
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                newsViewModel.newsResponse.value is Event.Loading
            }
        }
        lifecycleScope.launch {
            newsViewModel.newsResponse.collect {
                if (it is Event.Success) {
                    newsViewModel.saveNews(it.data!!.articles)
                }
            }
        }
        setContent {
            LaunchedEffect("start") {
                delay(5000L)
                newsViewModel.news(query = "Environment", apiKey = BuildConfig.NEWS_API_KEY)
            }
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
                            onNewsClick = { navController.navigate(MainPage.News.value) },
                            newsViewModel = newsViewModel
                        )
                    }
                    composable(MainPage.News.name) {
                        NewsScreen(
                            viewModel = newsViewModel
                        )
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