package com.tree.presentation.ui.map.component.bottomsheet

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.LatLng
import com.tree.design_system.theme.AceTheme
import com.tree.presentation.ui.map.component.MapFilterButton
import com.tree.presentation.ui.map.component.MapResultItem
import com.tree.presentation.viewmodel.EcoFriendlyLocationData
import com.tree.presentation.viewmodel.MapViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MapBottomSheet(
    ecoFriendlyLocationState: List<EcoFriendlyLocationData>,
    onFilterClick: () -> Unit,
    onLocationClick: (LatLng) -> Unit
) {
    Log.d("MapBottomSheet", "Recomposing with ${ecoFriendlyLocationState.size} items")
    AceTheme { colors, typography ->
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(colors.WHITE)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp))
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = "검색 결과",
                    style = typography.smallTitle,
                    fontWeight = FontWeight.SemiBold
                )
                MapFilterButton { onFilterClick() }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(colors.WHITE)
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(ecoFriendlyLocationState.size) { index ->
                        val listItem = ecoFriendlyLocationState[index]
                        Log.d("testt-d",listItem.toString())
                        if(listItem.title != null) {
                            MapResultItem(
                                title = listItem.title!!,
                                content = listItem.content!!
                            ) {
                                val latLng = LatLng(listItem.latitude!!,listItem.longitude!!)
                                onLocationClick(latLng)
                            }

                            Divider(
                                modifier = Modifier
                                    .height(1.dp)
                                    .background(colors.BLACK.copy(0.1f))
                            )
                        }
                    }
                }
            }
        }
    }
}