package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Root Composable for the screen
            SimpleRow()
        }
    }
}

@Composable
fun SimpleRow() {
    Row(
        modifier = Modifier
            .background(Color.Green) // Set background color
            .border(2.dp, Color.Cyan) // Add a border
            .padding(20.dp, 10.dp) // Add padding
            .fillMaxHeight(0.5f) // Occupy 50% of screen height
            .fillMaxWidth() // Occupy full screen width
//            .requiredWidth(400.dp) // Minimum width of the Row
    ) {
        Text(
            text = "Hello",
            modifier = Modifier.clickable {
                // Handle click event for the first Text composable
            }
        )
        Spacer(modifier = Modifier.width(20.dp)) // Space between Text composables
        Text(text = "Hello")
        Text(text = "Hello")
    }
}