package com.example.jetpackcompose

data class MyScreenState(
    val text:String="",
    val namesList:MutableList<String> = mutableListOf<String>()
)