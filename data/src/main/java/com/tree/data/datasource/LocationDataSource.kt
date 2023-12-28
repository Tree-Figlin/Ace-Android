package com.tree.data.datasource

import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow

interface LocationDataSource {
    suspend fun requestLocationUpdates(): Flow<LatLng?>

    suspend fun requestCurrentLocation(): Flow<LatLng?>
}