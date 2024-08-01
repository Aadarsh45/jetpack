package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
// loading of the image card

class lecture2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val painter = painterResource(id = R.drawable.logo)
            val description = "Logo Jetpack Compose fjjbajca hafjdjah adjandj"
            val title = "logo"
            Spacer(modifier = Modifier.height(30.dp))
            Box(modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .padding(20.dp, 26.dp)

                ){
                ImageCard(painter = painter, title = title, description = description)
            }


        }
    }
}

@Composable
fun ImageCard(painter: Painter,
              title:String,
              description:String,
              modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .fillMaxSize(),
             shape = RoundedCornerShape(15.dp),
//             elevation = 5.dp
        ) {
        Box (modifier = Modifier.height(200.dp)){
            Image(painter = painter,
                contentDescription = description,
                contentScale = ContentScale.Crop
            )
            Box (modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )
                )

            Box(modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
                contentAlignment = Alignment.BottomStart)  {
                Text(title, style = TextStyle(Color.White, fontSize = 16.sp))
            }


        }

    }

}

