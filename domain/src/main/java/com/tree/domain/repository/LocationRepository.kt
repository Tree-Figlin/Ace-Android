package com.tree.domain.repository

import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    suspend fun requestLocationUpdates(): Flow<LatLng?>

    suspend fun requestCurrentLocation(): Flow<LatLng?>
}