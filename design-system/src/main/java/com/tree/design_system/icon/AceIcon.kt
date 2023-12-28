package com.tree.design_system.icon

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.tree.design_system.R

@Composable
fun AceLogoIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_logo),
        contentDescription = "Logo Icon"
    )
}

@Composable
fun NextIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_next),
        contentDescription = "Next Icon"
    )
}

@Composable
fun SearchIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_search),
        contentDescription = "Search Icon"
    )
}

@Composable
fun NoSearchIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_no_search),
        contentDescription = "NO Search Icon"
    )
}

@Composable
fun BackIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_back),
        contentDescription = "Back Icon"
    )
}

@Composable
fun DeleteIcon() {
    Image(
        painter = painterResource(id = R.drawable.ic_delete),
        contentDescription = "Delete Icon"
    )
}

@Composable
fun NewsIcon(isClick: Boolean = false) {
    if (isClick) {
        Image(
            painter = painterResource(id = R.drawable.ic_news_click),
            contentDescription = "News Click Icon"
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.ic_news),
            contentDescription = "News Icon"
        )
    }
}

@Composable
fun HomeIcon(isClick: Boolean = false) {
    if (isClick) {
        Image(
            painter = painterResource(id = R.drawable.ic_home_click),
            contentDescription = "Home Click Icon"
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.ic_home),
            contentDescription = "Home Icon"
        )
    }
}

@Composable
fun EventIcon(isClick: Boolean = false) {
    if (isClick) {
        Image(
            painter = painterResource(id = R.drawable.ic_event_click),
            contentDescription = "Event Click Icon"
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.ic_event),
            contentDescription = "Event Icon"
        )
    }
}

@Composable
fun MapIcon(isClick: Boolean = false) {
    if (isClick) {
        Image(
            painter = painterResource(id = R.drawable.ic_map_click),
            contentDescription = "Map Click Icon"
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.ic_map),
            contentDescription = "Map Icon"
        )
    }
}