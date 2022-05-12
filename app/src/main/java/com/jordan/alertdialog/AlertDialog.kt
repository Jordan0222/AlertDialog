package com.jordan.alertdialog

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.jordan.alertdialog.ui.theme.Purple500


@Composable
fun AlertDialogAndDialog() {

    var showAlertDialog by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    val showInformationDialog = remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                showAlertDialog = !showAlertDialog
            }
        ) {
            Text(text = "Open Alert Dialog")
        }
        if (showAlertDialog) {
            AlertDialogExample {
                showAlertDialog = !showAlertDialog
            }
        }
        
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                showDialog = !showDialog
            }
        ) {
            Text(
                text = "Open Dialog"
            )
        }
        if (showDialog) {
            CustomIconDialog(
                onDismiss = {
                    showDialog = !showDialog
                    Toast.makeText(context, "Dialog Dismissed!", Toast.LENGTH_SHORT).show()
                },
                onNegativeClick = {
                    showDialog = !showDialog
                    Toast.makeText(context, "Negative Button Clicked!", Toast.LENGTH_SHORT).show()
                },
                onPositiveClick = {
                    showDialog = !showDialog
                    Toast.makeText(context, "Positive Button Clicked!", Toast.LENGTH_SHORT).show()
                }
            )
        }
        
        InformationDialog(isDialogOpen = showInformationDialog)

        Button(
            onClick = {
                showInformationDialog.value = true
            },
            modifier = Modifier
                .padding(10.dp)
                .height(50.dp),
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(Purple500)
        ) {
            Text(
                text = "Show Popup",
                color = Color.White
            )
        }
    }
}

@Composable
fun AlertDialogExample(
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false,
            securePolicy = SecureFlagPolicy.Inherit
        ),
        title = {
            Text(
                text = "AlertDialog with Style",
                fontWeight = Bold
            )
        },
        text = {
            Text(text = "This dialog has buttons with custom style and aligned vertically as in Column. Properties set custom behaviour of a dialog such as dismissing when back button pressed or pressed outside of dialog")
        },
        buttons = {
            OutlinedButton(
                shape = RoundedCornerShape(percent = 30),
                onClick = onDismiss,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Cancel")
            }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(
                shape = RoundedCornerShape(percent = 30),
                onClick = onDismiss,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color(0xff8BC34A),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "OK")
            }
        }
    )
}