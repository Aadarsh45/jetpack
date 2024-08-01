package com.example.jetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme


class Adding_text_to_ui : ComponentActivity() {
    val viewModel by lazy{ViewModelProvider(this).get(MyViewModel::class.java)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val state = viewModel.state.value
            JetpackComposeTheme {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .imePadding()
                    .background(color = Color.Blue)

                  ) {
//                    var texState by remember {
//                        mutableStateOf("")
//                    }
//                    val list = remember {
//                        mutableStateListOf<String>()
//                    }
                     LazyColumn (modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(10.dp,20.dp)
                        ){
                        items(state.namesList.size){
                            Text(text = state.namesList[it])
                        }


                    }
                    help(textValue = state.text, onValueChange = {
                        viewModel.updateText(it)}
                        ,
                        onAdd = {
                            viewModel.updateNamesList()
                            viewModel.updateText("")
                        }
                    )
                }

            }
        }
    }
}

@Composable
fun help(textValue:String,
         onValueChange:(String)->Unit,
         onAdd:() -> Unit) {

    TextField(value = textValue, onValueChange = {
        onValueChange(it)
    },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = "Add",
                modifier = Modifier.clickable {
                    onAdd()
                }
            )
        }
    )
}


