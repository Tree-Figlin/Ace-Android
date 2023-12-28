package com.tree.design_system.component.bottombar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tree.design_system.icon.EventIcon
import com.tree.design_system.icon.HomeIcon
import com.tree.design_system.icon.MapIcon
import com.tree.design_system.icon.NewsIcon
import com.tree.design_system.theme.AceTheme

@Composable
fun AceBottomNavigationBar(
    modifier: Modifier,
    isVisible: Boolean,
    currentRoute: String,
    onNewsClick: () -> Unit,
    onHomeClick: () -> Unit,
    onEventClick: () -> Unit,
    onMapClick: () -> Unit
) {
    if (isVisible) {
        AceTheme { colors, typography ->
            Column(
                modifier = modifier
                    .height(64.dp)
                    .background(
                        color = colors.BLACK.copy(alpha = 0.1f),
                        shape = RoundedCornerShape(
                            topStart = 12.dp,
                            topEnd = 12.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    ),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(63.dp)
                        .background(
                            color = colors.WHITE,
                            shape = RoundedCornerShape(
                                topStart = 12.dp,
                                topEnd = 12.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 0.dp
                            )
                        )
                        .padding(horizontal = 32.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .width(48.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { onHomeClick() },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        HomeIcon(isClick = currentRoute == "Home")
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "홈",
                            style = typography.caption,
                            color = if (currentRoute == "Home") colors.PRIMARY else colors.GREYSCALE3,
                            fontWeight = FontWeight.Normal
                        )
                    }
                    Column(
                        modifier = Modifier
                            .width(48.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { onNewsClick() },
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        NewsIcon(isClick = currentRoute == "News")
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "검색",
                            style = typography.caption,
                            color = if (currentRoute == "News") colors.PRIMARY else colors.GREYSCALE3,
                            fontWeight = FontWeight.Normal
                        )
                    }
                    Column(
                        modifier = Modifier
                            .width(48.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { onEventClick() },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        EventIcon(isClick = currentRoute == "Event")
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "이벤트",
                            style = typography.caption,
                            color = if (currentRoute == "Event") colors.PRIMARY else colors.GREYSCALE3,
                            fontWeight = FontWeight.Normal
                        )
                    }
                    Column(
                        modifier = Modifier
                            .width(48.dp)
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) { onMapClick() },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MapIcon(isClick = currentRoute == "Map")
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "지도",
                            style = typography.caption,
                            color = if (currentRoute == "Map") colors.PRIMARY else colors.GREYSCALE3,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AceBottomNavigationBarPreView() {
    AceBottomNavigationBar(
        modifier = Modifier,
        isVisible = true,
        currentRoute = "",
        onNewsClick = {},
        onHomeClick = {},
        onEventClick = {},
        onMapClick = {}
    )
}