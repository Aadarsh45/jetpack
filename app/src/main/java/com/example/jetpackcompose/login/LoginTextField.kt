package com.example.jetpackcompose.login

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.jetpackcompose.login.ui.theme.Black
import com.example.jetpackcompose.login.ui.theme.focusedTextFieldContainer
import com.example.jetpackcompose.login.ui.theme.focusedTextFieldText
import com.example.jetpackcompose.login.ui.theme.unfocusedTextFieldText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(modifier: Modifier = Modifier,
                   label:String,
                   trailing:String? = null
) {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    TextField(
        value = "" ,
        onValueChange = {},
        modifier = modifier,
        label = {
            Text(text = label, style = MaterialTheme.typography.labelMedium, color = uiColor)
        },
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.focusedTextFieldContainer,
            focusedContainerColor = MaterialTheme.colorScheme.focusedTextFieldContainer,
        ),
        trailingIcon ={
            TextButton(onClick = { /*TODO*/ }) {
                if (trailing != null) {
                    Text(
                        text = trailing,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                        color = uiColor
                    )
                }
            }

        }


    )
}