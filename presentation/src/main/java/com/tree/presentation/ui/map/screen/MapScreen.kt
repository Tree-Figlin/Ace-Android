package com.tree.presentation.ui.map.screen

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.tree.presentation.ui.map.component.MapPreview
import com.tree.presentation.viewmodel.MapViewModel

@Composable
fun MapScreen(
    navController: NavController,
    viewModel: MapViewModel,
    onBack: () -> Unit
) {
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { isGrantedMap: Map<String, Boolean> -> }

    LaunchedEffect("Permission") {
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    MapPreview(
        navController = navController,
        viewModel = viewModel,
        onBack = { onBack() }
        )
}