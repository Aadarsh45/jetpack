package com.example.jetpackcompose

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel(){
    val state = mutableStateOf(MyScreenState())

    fun updateText(newText:String){
        state.value = state.value.copy(text = newText)
    }

    fun updateNamesList(){
        val curentList = state.value.namesList
        curentList.add(state.value.text)
        state.value = state.value.copy(namesList = curentList)
    }
}