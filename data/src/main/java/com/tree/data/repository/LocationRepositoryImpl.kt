package com.tree.data.repository

import android.util.Log
import com.google.android.gms.maps.model.LatLng
import com.tree.data.datasource.LocationDataSource
import com.tree.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationDataSource: LocationDataSource
): LocationRepository {
    override suspend fun requestLocationUpdates(): Flow<LatLng?> {
        return locationDataSource.requestLocationUpdates()
    }

    override suspend fun requestCurrentLocation(): Flow<LatLng?> {
        TODO("Not yet implemented")
    }

}