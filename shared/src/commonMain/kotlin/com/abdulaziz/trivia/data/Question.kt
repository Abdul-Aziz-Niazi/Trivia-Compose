package com.abdulaziz.trivia.data

@kotlinx.serialization.Serializable
data class Question(
    val questionText: String,
    val correctAnswer: String,
    val incorrectAnswers: ArrayList<String>
)