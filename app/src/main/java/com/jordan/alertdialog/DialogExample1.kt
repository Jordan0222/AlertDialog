package com.jordan.alertdialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun CustomIconDialog(
    onDismiss: () -> Unit,
    onNegativeClick: () -> Unit,
    onPositiveClick: () -> Unit,
) {
    Dialog(onDismissRequest = onDismiss ) {
        val color = Color(0xff4DB6AC)
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(color = color)
                ) {
                    Icon(
                        tint = Color.White,
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null,
                        modifier = Modifier
                            .graphicsLayer(scaleX = 1.2f, scaleY = 1.2f)
                            .align(Alignment.Center)
                    )
                }
                
                Column(modifier = Modifier.padding(16.dp)) {
                    CompositionLocalProvider(
                        LocalContentAlpha provides ContentAlpha.medium
                    ) {
                        Text("To send a nearby place or your location, allow access to your location.")
                    }
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "NOT NOW",
                            color = color,
                            modifier = Modifier
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = rememberRipple(color = Color.DarkGray),
                                    onClick = onNegativeClick
                                )
                                .padding(8.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "CONTINUE",
                            color = color,
                            modifier = Modifier
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = rememberRipple(color = Color.DarkGray),
                                    onClick = onPositiveClick
                                )
                                .padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}