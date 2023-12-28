package com.tree.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.maps.android.compose.GoogleMap
import com.tree.presentation.ui.theme.FiglinAceTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FiglinAceTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    GoogleMap(
        modifier = Modifier.fillMaxSize()
    ) {}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FiglinAceTheme {
        Greeting()
    }
}