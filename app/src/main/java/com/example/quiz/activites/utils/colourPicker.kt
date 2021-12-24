package com.example.quiz.activites.utils

object colourPicker

{
    val color= arrayOf("#7D6608","#2C3E50","#B2BABB","#5D6D7E","#D98880","#BB8FCE","#7FB3D5","#1ABC9C","#F0B27A")
    var currentColorIndex=0
    fun getcolor():String{
        currentColorIndex=(currentColorIndex+1) % color.size
        return color[currentColorIndex]

    }

}