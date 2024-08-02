package com.example.jetpackcompose.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.login.ui.theme.Black
import com.example.jetpackcompose.login.ui.theme.BlueGray
import com.example.jetpackcompose.login.ui.theme.Roboto

@Composable
fun Mylogin_Screen() {
    Surface {
       Column(modifier = Modifier.fillMaxSize()) {

           TopSection()
           Spacer(modifier = Modifier.width(39.dp))
           Column(modifier = Modifier
               .fillMaxSize()
               .padding(horizontal = 30.dp)) {
               loginSection()

               Spacer(modifier = Modifier.height(30.dp))

               SocialmediaSection()
               val uiColor = if (isSystemInDarkTheme()) Color.White else Black

               Spacer(modifier = Modifier.height(30.dp))

               Box(modifier = Modifier
                   .fillMaxHeight(0.8f)
                   .fillMaxWidth(),
                   contentAlignment = Alignment.Center){

                   Text(
                       text = buildAnnotatedString {
                           withStyle(
                               style = SpanStyle(
                                   color = Color(0xFF94A388),
                                   fontSize = 14.sp
                                   , fontFamily = Roboto,
                                   fontWeight = FontWeight.Normal
                               )
                           ){
                               append("Don't have an Account?")
                           }
                           withStyle(
                               style = SpanStyle(
                                   color = Color(0xFF94A388),
                                   fontSize = 14.sp
                                   , fontFamily = Roboto,
                                   fontWeight = FontWeight.Medium
                               )
                           ){
                               append(" ")
                               append("Create Account")
                           }
                       }

                   )
               }



           }
       }
    }

}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.46f),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Row(
            modifier = Modifier.padding(80.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(36.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = stringResource(id = R.string.app_logo),
                tint = uiColor
            )
            Spacer(modifier = Modifier.width(15.dp))

            Column {
                Text(
                    text = stringResource(id = R.string.tolet),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )
                Text(
                    text = stringResource(id = R.string.findhouse),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(BottomCenter),
            text = stringResource(id = R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )


    }
}

@Composable
private fun loginSection() {
    LoginTextField(Modifier.fillMaxWidth(), "Email", "")
    Spacer(modifier = Modifier.height(15.dp))
    LoginTextField(Modifier.fillMaxWidth(), "Password", "Show")

    Spacer(modifier = Modifier.height(15.dp))

    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp), onClick = {}, colors = ButtonDefaults.buttonColors(
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black,
            contentColor = Color.White
        ), shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            text = "Log in",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}
@Composable
private fun SocialmediaSection(){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF647488))
        )
        Spacer(modifier = Modifier.height(20.dp))

        Row(modifier = Modifier.fillMaxWidth(),

            verticalAlignment = Alignment.CenterVertically){
            SocialMedia(icon = R.drawable.google, text = "Google", modifier = Modifier.weight(1f)) {

            }
            Spacer(modifier = Modifier.width(20.dp))
            SocialMedia(icon = R.drawable.facebook, text = "Facebook", modifier = Modifier.weight(1f)) {

            }


        }

    }
}
    



