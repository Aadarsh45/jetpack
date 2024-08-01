package com.example.jetpackcompose

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.MutedBlack

data class Publisher(
    @DrawableRes val image: Int
    ,val name:String
    ,val job:String
)

@Composable
fun MyCustumCard(modifier: Modifier = Modifier,
                 @DrawableRes image:Int,
                 tittle:String,
                 text:String,
                 publisher: Publisher
) {
    var state: Boolean by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = modifier.animateContentSize()
            ,elevation = CardDefaults.elevatedCardElevation(10.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MutedBlack
        )

    ){
        Column {
            Image(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column(modifier =Modifier.padding(20.dp,15.dp)) {
                Text(text = tittle,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(modifier = Modifier.clickable {
                    state = !state
                }
                    ,text = text,
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                    ,overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                    ,maxLines = if (state) Int.MAX_VALUE else 2
                )
                Spacer(modifier = Modifier.height(30.dp))

                Row {
                    Image(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = publisher.image),
                        contentDescription = null)
                    Spacer(modifier = Modifier.width(10.dp))

                    val annotatedString = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = 18.sp

                            )

                        ){
                            append(publisher.name)
                        }
                        append("\n")
                        withStyle(
                            style = SpanStyle(
                                color = Color.White.copy(alpha = 0.7f),
                                fontSize = 16.sp

                            )

                        ){
                            append(publisher.job)
                        }
                    }
                    Text(text = annotatedString)
                }



            }
        }

    }
}