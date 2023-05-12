package com.abdulaziz.desktop

import androidx.compose.ui.window.application
import com.abdulaziz.trivia.navigation.SetupNavGraph
import moe.tlaster.precompose.PreComposeWindow

fun main() = application {
    PreComposeWindow(onCloseRequest = ::exitApplication, title = "Trivia-Compose") {
        SetupNavGraph()
    }
}