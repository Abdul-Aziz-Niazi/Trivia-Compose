package com.abdulaziz.trivia

import android.app.Application
import androidx.compose.runtime.Composable
import com.abdulaziz.trivia.navigation.SetupNavGraph

@Composable
fun Application(){
    SetupNavGraph()
}