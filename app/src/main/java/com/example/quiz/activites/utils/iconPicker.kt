package com.example.quiz.activites.utils

import com.example.quiz.R


object iconPicker
{
    val icons= arrayOf(
        R.drawable.ic_baseline_book_24,
        R.drawable.ic_baseline_assessment_24,
        R.drawable.ic_baseline_auto_fix_normal_24,
        R.drawable.ic_baseline_auto_graph_24,
        R.drawable.ic_baseline_auto_stories_24,
        R.drawable.ic_baseline_batch_prediction_24,
        R.drawable.ic_baseline_blur_on_24,
        R.drawable.ic_baseline_gamepad_24,
        R.drawable.ic_baseline_border_color_24,

       )
    var currentColorIndex=0
    fun geticon(): Int
    {
        currentColorIndex=(currentColorIndex+1)% icons.size
        return icons[currentColorIndex]
    }

}