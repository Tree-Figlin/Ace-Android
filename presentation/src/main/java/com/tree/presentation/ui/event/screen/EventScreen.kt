package com.tree.presentation.ui.event.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tree.design_system.component.text.AceTitleText
import com.tree.presentation.ui.event.component.EventList
import com.tree.presentation.ui.event.data.EventListItem
import com.tree.presentation.ui.event.data.list

@Composable
fun EventScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 80.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            AceTitleText(
                modifier = Modifier.weight(1f),
                text = "이벤트"
            )
        }
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            EventList(
                list = list,
                onItemClick = {}
            )
        }
    }
}