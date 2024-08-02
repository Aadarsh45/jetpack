package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class Textfield : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTheme {
                Column(modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                    ) {
                    var state by rememberSaveable {
                       mutableStateOf("")}
                    var isPass by remember {
                        mutableStateOf(false)
                    }
                    TextField(value = state
                        ,onValueChange = {state = it}
                        ,leadingIcon = {
                            Icon(painter = painterResource(id = R.drawable.baseline_key_24), contentDescription = null)
                        },
                        trailingIcon = {
                            TextButton(onClick={isPass = !isPass}){
                                Text(text = if(isPass)"Hide" else "Show")
                            }
                        },
                        colors = TextFieldDefaults.textFieldColors(
//                            containerColor = Color.Transparent,
//                            cursorColor = Color.Red
                        ),
                        singleLine = true,
                        placeholder = {
                            Text(text = "Enter your password")
                        },
//                        label = {
//                            Text(text = "Password")
//                        }
                        visualTransformation = if(isPass) VisualTransformation.None else PasswordVisualTransformation(),

                        keyboardOptions = KeyboardOptions(
                            autoCorrect = false,
                            keyboardType = KeyboardType.NumberPassword,
                            imeAction = ImeAction.Go
                        ),
                        keyboardActions = KeyboardActions(
                            onGo = {
                                Log.d("test","On Go Click")
                            }
                        )



                    )




                }
            }
        }
    }
}
