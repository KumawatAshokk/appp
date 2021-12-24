package com.example.quiz.activites.utils

import com.example.quiz.R


object iconPicker
{
    val icons= arrayOf(
        R.drawable.ic_baseline_book_24,
       )
    var currentColorIndex=0
    fun geticon(): Int
    {
        currentColorIndex=(currentColorIndex+1)% icons.size
        return icons[currentColorIndex]
    }

}