package com.example.quiz.activites.model

data class quiz(
    var id:String="",
    var Title:String="",
    var Question:MutableMap<String,Question> = mutableMapOf()

    )