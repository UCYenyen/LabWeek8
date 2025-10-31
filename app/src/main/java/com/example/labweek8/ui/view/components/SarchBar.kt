package com.example.labweek8.ui.view.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    val baseColor = Color.White.copy(alpha = 0.1f)
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            placeholder = { Text(hint) },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = baseColor,
                unfocusedContainerColor = baseColor,
                disabledContainerColor = baseColor,

                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedPlaceholderColor = Color.White.copy(alpha = 0.8f),
                unfocusedPlaceholderColor = Color.White.copy(alpha = 0.8f),

                focusedLeadingIconColor = Color.White,
                unfocusedLeadingIconColor = Color.White,
                focusedTrailingIconColor = Color.White,
                unfocusedTrailingIconColor = Color.White,

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            modifier = modifier
                .weight(1f)
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.25f),
                    shape = RoundedCornerShape(12.dp)
                ),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClick()
                    keyboardController?.hide()
                }
            )
        )

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = {
                onSearchClick()
                keyboardController?.hide()
            },
            modifier = Modifier
                .padding(vertical = 12.dp)
                .border(
                    width = 1.dp,
                    color = Color.White.copy(alpha = 0.25f),
                    shape = RoundedCornerShape(12.dp)
                ),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonColors(
                containerColor = baseColor,
                contentColor = Color.White,
                disabledContainerColor = baseColor,
                disabledContentColor = baseColor
            ),
            contentPadding = PaddingValues(vertical = 14.dp, horizontal = 14.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                tint = Color.White,
                contentDescription = "Search Icon"
            )
            Text("Search")
        }
    }
}

@Preview
@Composable
private fun SearchBarPreview() {
    SearchBar(
        text = "",
        onTextChange = {},
        onSearchClick = {},
        hint = "Search",
    )
}