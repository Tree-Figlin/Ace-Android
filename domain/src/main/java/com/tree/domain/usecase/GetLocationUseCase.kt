package com.tree.domain.usecase

import com.google.android.gms.maps.model.LatLng
import com.tree.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLocationUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {
    suspend operator fun invoke(): Flow<LatLng?> = locationRepository.requestLocationUpdates()
}