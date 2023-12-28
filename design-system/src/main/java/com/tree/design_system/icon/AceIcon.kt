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