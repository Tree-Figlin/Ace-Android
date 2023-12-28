package com.tree.presentation.ui.map.component

import android.Manifest
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.maps.android.compose.GoogleMap

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapPreview(
    navController: NavController,
    onLunched: () -> Unit,
    onBack: () -> Unit
) {
    val permissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )
    if(permissionState.allPermissionsGranted) {
        onLunched()
        GoogleMap(
            modifier = Modifier.fillMaxSize()
        ) {

        }
    } else {
        onBack()
    }
}