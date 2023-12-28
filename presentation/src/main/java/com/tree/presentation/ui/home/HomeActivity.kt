package com.tree.presentation.ui.home

import android.util.Log
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
import com.tree.domain.model.news.response.ArticleListModel
import com.tree.presentation.BuildConfig
import com.tree.presentation.ui.base.BaseActivity
import com.tree.presentation.ui.event.screen.EventScreen
import com.tree.presentation.ui.home.screen.HomeScreen
import com.tree.presentation.ui.map.screen.MapScreen
import com.tree.presentation.ui.news.screen.NewsDetailScreen
import com.tree.presentation.ui.news.screen.NewsScreen
import com.tree.presentation.viewmodel.NewsViewModel
import com.tree.presentation.viewmodel.util.Event
import com.tree.presentation.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class MainPage(val value: String) {
    Home("Home"),
    News("News"),
    Event("Event"),
    Map("Map")
}

enum class SubPage(val value: String) {
    NewsDetail("NewsDetail")
}

@AndroidEntryPoint
class HomeActivity : BaseActivity() {
    private val newsViewModel by viewModels<NewsViewModel>()
    private val mapViewModel by viewModels<MapViewModel>()

    private lateinit var news: ArticleListModel

    override fun init() {
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                newsViewModel.newsResponse.value is Event.Loading
            }
        }
        newsViewModel.news(query = "Environment", apiKey = BuildConfig.NEWS_API_KEY)
        lifecycleScope.launch {
            newsViewModel.newsResponse.collect {
                if (it is Event.Success) {
                    newsViewModel.saveNews(it.data!!.articles)
                }
            }
        }
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
                            newsViewModel = newsViewModel,
                            onNewsClick = { navController.navigate(MainPage.News.value) },
                            onEventClick = { navController.navigate(MainPage.Event.value) },
                            onMapClick = { navController.navigate(MainPage.Map.value) }
                        )
                    }
                    composable(MainPage.News.name) {
                        NewsScreen(
                            viewModel = newsViewModel,
                            onItemClick = {
                                news = it
                                navController.navigate(SubPage.NewsDetail.value)
                            }
                        )
                    }
                    composable(MainPage.Event.name) {
                        EventScreen()
                    }
                    composable(MainPage.Map.name) {
                        MapScreen(
                            navController = navController,
                            viewModel = mapViewModel,
                            onBack = { navController.popBackStack() }
                        )
                    }
                    composable(SubPage.NewsDetail.name) {
                        NewsDetailScreen(
                            context = this@HomeActivity,
                            news = news,
                            onBackClick = { navController.popBackStack() }
                        )
                    }
                }
                AceBottomNavigationBar(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    isVisible = currentRoute in MainPage.values().map { it.name },
                    currentRoute = currentRoute ?: "Home",
                    onNewsClick = { navController.navigate(MainPage.News.value) },
                    onHomeClick = { navController.navigate(MainPage.Home.value) },
                    onEventClick = { navController.navigate(MainPage.Event.value) },
                    onMapClick = { navController.navigate(MainPage.Map.value) }
                )
            }
        }
    }
}