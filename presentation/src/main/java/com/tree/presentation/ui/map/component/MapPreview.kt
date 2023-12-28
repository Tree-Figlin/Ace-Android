package com.tree.presentation.ui.map.component

import android.Manifest
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.rememberCameraPositionState
import com.tree.presentation.ui.map.component.bottomsheet.MapBottomSheet
import com.tree.presentation.viewmodel.MapViewModel
import com.tree.presentation.viewmodel.PermissionEvent
import kotlinx.coroutines.delay

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapPreview(
    navController: NavController,
    viewModel: MapViewModel,
    onBack: () -> Unit,
    onGetResult: () -> Unit
) {
    val cameraState = rememberCameraPositionState()
    var currentLocation: LatLng
    val permissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )
    if(permissionState.allPermissionsGranted) {
        viewModel.getUserLocation(PermissionEvent.Granted)

        LaunchedEffect(viewModel.latitude, viewModel.longitude) {
            if(viewModel.latitude != 0.0 && viewModel.longitude != 0.0) {
                currentLocation = LatLng(viewModel.latitude, viewModel.longitude)
                cameraState.centerOnLocation(currentLocation)
            }
        }

        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .height(312.dp),
            cameraPositionState = cameraState,
            properties = MapProperties(
                isMyLocationEnabled = true,
                mapType = MapType.NORMAL,
                isTrafficEnabled = true
            )
        ) {}

        viewModel.getResult()
    } else {
        onBack()
    }
}

private suspend fun CameraPositionState.centerOnLocation(
    location: LatLng
) = animate(
    update = CameraUpdateFactory.newLatLngZoom(
        location, 15f
    ),
    durationMs = 2500
)