package com.example.quiz.activites.model

data class quiz(
    var id:String="",
    var title:String="",
    var question:MutableMap<String,question> = mutableMapOf()

    )