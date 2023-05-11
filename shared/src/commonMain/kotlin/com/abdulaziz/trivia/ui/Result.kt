package com.abdulaziz.trivia.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulaziz.trivia.theme.AppStyles
import com.abdulaziz.trivia.theme.Green200
import com.abdulaziz.trivia.theme.Green500
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun Result(navigator: Navigator, correct: Int) {
    var result by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()
    val resultEmoji = when (result) {
        in 0..40 -> "😭"
        in 41..60 -> "😐"
        in 61..80 -> "\uD83E\uDD29"
        in 81..100 -> "\uD83E\uDD73"
        else -> "🥳"
    }
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        scope.launch {
            while (result < (correct * 10)) {
                result += 1
                delay(400)
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text("Quiz Result", style = AppStyles.textTitle.copy(fontSize = 50.sp, color = Green500), modifier = Modifier.padding(16.dp))
        Spacer(modifier = Modifier.height(16.dp))
        Text("$result%", style = AppStyles.textTitle.copy(color = Color.Black, fontSize = 40.sp), modifier = Modifier.padding(8.dp))
        Text(resultEmoji, style = AppStyles.textTitle.copy(fontSize = 90.sp))

        //Tech Stack
        Text("Tech Stack", style = AppStyles.textTitle.copy(fontSize = 40.sp, color = Color.Black), modifier = Modifier.padding(16.dp))
        Text("Kotlin Multiplatform", style = AppStyles.textTitle.copy(color = Color.Black, fontSize = 20.sp), modifier = Modifier.padding(8.dp))
        Text("Compose Multiplatform", style = AppStyles.textTitle.copy(color = Color.Black, fontSize = 20.sp), modifier = Modifier.padding(8.dp))
        Text("Github: Abdul-Aziz-Niazi", style = AppStyles.textTitle.copy(color = Color.Black, fontSize = 20.sp), modifier = Modifier.padding(8.dp))

        if (result == (correct * 10)) {
            Button(onClick = {
                navigator.popBackStack()
            }, modifier = Modifier.padding(16.dp)) {
                Text("Back to Home")
            }
        }

    }
}