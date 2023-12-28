package com.tree.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import com.tree.domain.usecase.GetLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val getLocationUseCase: GetLocationUseCase
) : ViewModel() {
    private val _viewState: MutableStateFlow<ViewState> = MutableStateFlow(ViewState.Loading)
    val viewState = _viewState.asStateFlow()

    private val _ecoFriendlyLocation = MutableStateFlow(
        listOf(
            EcoFriendlyLocationData(
                province = null,
                content = null,
                latitude = null,
                longitude = null,
                title = null
            )
        )
    )
    val ecoFriendlyLocation = _ecoFriendlyLocation.asStateFlow()

    private var _latitude: Double = 0.0
    private var _longitude: Double = 0.0

    val latitude: Double
        get() = _latitude

    val longitude: Double
        get() = _longitude

    fun handle(event: PermissionEvent) {
        when (event) {
            PermissionEvent.Granted -> {
                viewModelScope.launch {
                    getLocationUseCase.invoke().collect {
                        // latitude 및 longitude 프로퍼티를 업데이트
                        _latitude = it?.latitude ?: 0.0
                        _longitude = it?.longitude ?: 0.0

                        // viewState를 업데이트
                        _viewState.value = ViewState.Success(it)
                    }
                }
            }

            PermissionEvent.Revoked -> {
                _viewState.value = ViewState.RevokedPermissions
            }
        }
    }

    fun getAiAnswer() {
        val query: Query = getMessageQuery()
        val valueEventListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val locationList = mutableListOf<EcoFriendlyLocationData>()

                for (dataSnapshotEntry in snapshot.children) {
                    val locationData = dataSnapshotEntry.getValue(EcoFriendlyLocationData::class.java)
                    locationData?.let {
                        locationList.add(it)
                    }
                }

                _ecoFriendlyLocation.value = locationList
                Log.d("testt", _ecoFriendlyLocation.value.toString())
            }
            override fun onCancelled(error: DatabaseError) {
                Log.d("testt",error.details)
            }
        }
        query.addValueEventListener(valueEventListener)
    }

    private fun getMessageQuery(): Query {
        return FirebaseDatabase.getInstance().getReference()
            .child("EcoFriendlyLocation")
    }
}

sealed interface ViewState {
    object Loading : ViewState
    data class Success(val location: LatLng?) : ViewState
    object RevokedPermissions : ViewState
}

sealed interface PermissionEvent {
    object Granted : PermissionEvent
    object Revoked : PermissionEvent
}

data class EcoFriendlyLocationData(
    val province: String? = null,
    val latitude: Double? = null,
    val title: String? = null,
    val content: String? = null,
    val longitude: Double? = null
)