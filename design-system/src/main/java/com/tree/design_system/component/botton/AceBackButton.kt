package com.tree.design_system.component.botton

import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import com.tree.design_system.icon.BackIcon

@Composable
fun AceBackButton(onClick: () -> Unit) {
    IconButton(onClick = { onClick() }) {
        BackIcon()
    }
}