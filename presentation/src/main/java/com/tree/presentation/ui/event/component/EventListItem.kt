package com.tree.presentation.ui.event.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.tree.design_system.theme.AceTheme

@Composable
fun EventListItem(
    title: String,
    date: String,
    imageUrl: String,
    onItemClick: () -> Unit
) {
    AceTheme { colors, typography ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) { onItemClick() },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (imageUrl.isNotBlank()) {
                AsyncImage(
                    model = imageUrl,
                    modifier = Modifier
                        .width(85.dp)
                        .height(64.dp)
                        .clip(shape = RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                )
            } else {
                Box(
                    modifier = Modifier
                        .width(85.dp)
                        .height(64.dp)
                        .clip(shape = RoundedCornerShape(12.dp))
                        .background(colors.GREYSCALE4),
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = typography.largeBody,
                    fontWeight = FontWeight.Normal,
                    color = colors.BLACK,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = date,
                    style = typography.smallBody,
                    fontWeight = FontWeight.Normal,
                    color = colors.GREYSCALE3,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}