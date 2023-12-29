package com.tree.presentation.ui.map.component

import android.Manifest
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
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
    mapLocation: String
) {
    val locationState = viewModel.ecoFriendlyLocation.collectAsState()

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
        LaunchedEffect(viewModel.resultLatLng.value) {
            if(viewModel.resultLatLng.value.latitude != 0.0 && viewModel.resultLatLng.value.longitude != 0.0) {
                currentLocation = LatLng(viewModel.resultLatLng.value.latitude, viewModel.resultLatLng.value.longitude)
                cameraState.centerOnLocation(currentLocation)
            }
        }
        LaunchedEffect(mapLocation) {
            Log.d("testt","launched")
            when(mapLocation) {
                "전라" -> viewModel.changeUserLocation(35.143066, 126.800463)
            }
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
        ) {
            locationState.value.forEach { locationData ->
                locationData.latitude?.let { latitude ->
                    locationData.longitude?.let { longitude ->
                        Marker(
                            state = MarkerState(position = LatLng(latitude, longitude)),
                            title = locationData.title ?: "",
                            snippet = locationData.content ?: ""
                        )
                    }
                }
            }
        }

        viewModel.getResult()
    } else {
        onBack()
    }
}

private suspend fun CameraPositionState.centerOnLocation(
    location: LatLng
) = animate(
    update = CameraUpdateFactory.newLatLngZoom(
        location, 17f
    ),
    durationMs = 2500
)