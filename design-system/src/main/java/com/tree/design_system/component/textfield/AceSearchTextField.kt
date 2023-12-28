package com.tree.design_system.component.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import com.tree.design_system.component.botton.DeleteButton
import com.tree.design_system.theme.AceTheme
import kotlinx.coroutines.delay

@Composable
fun AceSearchTextField(
    modifier: Modifier = Modifier,
    debounceTime: Long = 300L,
    placeHolder: String = "",
    readOnly: Boolean = false,
    focusManager: FocusManager = LocalFocusManager.current,
    focusRequester: FocusRequester = FocusRequester(),
    setText: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    maxLines: Int = Int.MAX_VALUE,
    singleLine: Boolean = false,
    onValueChange: (String) -> Unit = {},
    onSearchTextChange: (String) -> Unit,
) {
    val isFocused = remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        onDispose {
            focusManager.clearFocus()
        }
    }

    LaunchedEffect(setText) {
        delay(debounceTime)
        onSearchTextChange(setText)
    }

    AceTheme { colors, typography ->
        Column(modifier = modifier) {
            TextField(
                value = setText,
                onValueChange = {
                    onValueChange(it)
                },
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                placeholder = {
                    Text(
                        text = placeHolder,
                        style = typography.smallTitle,
                        color = colors.GREYSCALE3,
                        fontWeight = FontWeight.Normal
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
                    .onFocusChanged {
                        isFocused.value = it.isFocused
                    },
                maxLines = maxLines,
                singleLine = singleLine,
                textStyle = typography.smallTitle,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = colors.BLACK,
                    backgroundColor = Color.Transparent,
                    placeholderColor = colors.GREYSCALE3,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,
                    cursorColor = colors.BULE1
                ),
                trailingIcon = {
                    DeleteButton {
                        onValueChange("")
                    }
                },
                readOnly = readOnly
            )
        }
    }
}