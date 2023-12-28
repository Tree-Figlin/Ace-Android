package com.tree.presentation.ui.map.screen

import android.Manifest
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.tree.design_system.theme.AceTheme
import com.tree.presentation.ui.map.component.MapPreview
import com.tree.presentation.ui.map.component.MapTopBar
import com.tree.presentation.ui.map.component.bottomsheet.MapBottomSheet
import com.tree.presentation.viewmodel.MapViewModel

@Composable
fun MapScreen(
    navController: NavController,
    viewModel: MapViewModel,
    onBack: () -> Unit
) {
    val ecoFriendlyLocationState by viewModel.ecoFriendlyLocation.collectAsState()

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { isGrantedMap: Map<String, Boolean> -> }

    var isGetResult by remember { mutableStateOf(false) }

    LaunchedEffect("Permission") {
        permissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    AceTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.GREYSCALE3)
        ) {
            MapTopBar { onBack() }
            MapPreview(
                navController = navController,
                viewModel = viewModel,
                onBack = { onBack() },
                onGetResult = { isGetResult = true}
            )
            MapBottomSheet(
                ecoFriendlyLocationState = ecoFriendlyLocationState,
                onLocationClick = {
                    viewModel.resultLatLng.value = it
                    Log.d("testt",it.toString())
                    Log.d("testt",viewModel.resultLatLng.toString())
                },
                onFilterClick = {}
            )
        }
    }
}