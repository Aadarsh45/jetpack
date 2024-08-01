package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class CreateaPostcard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                 Box(modifier = Modifier
                     .fillMaxSize()
                     .background(Color.Black.copy(alpha = 0.8f))
                      ,contentAlignment = Alignment.Center){
                     MyCustumCard(
                         modifier = Modifier.fillMaxWidth(0.8f),
                         image = R.drawable.p2,
                         tittle = "A Boy",
                         text = " The dp array is used to store the maximum sum of non-adjacent elements up to each index.",
                         publisher = Publisher(R.drawable.logo,"Aadarsh","Android Developer")
                      )
                 }

            }
        }
    }
}

