package com.tree.design_system.component.botton

import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import com.tree.design_system.icon.NextIcon
import com.tree.design_system.icon.SearchIcon

@Composable
fun SearchButton(onClick: () -> Unit) {
    IconButton(onClick = { onClick() }) {
        SearchIcon()
    }
}