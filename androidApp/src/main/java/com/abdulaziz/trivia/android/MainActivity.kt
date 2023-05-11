package com.abdulaziz.trivia.android

import android.os.Bundle
import androidx.compose.material.Scaffold
import androidx.core.view.WindowInsetsControllerCompat
import com.abdulaziz.trivia.Application
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import moe.tlaster.precompose.lifecycle.PreComposeActivity
import moe.tlaster.precompose.lifecycle.setContent

class MainActivity : PreComposeActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUIController = rememberSystemUiController()
            systemUIController.isSystemBarsVisible = false
            systemUIController.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            Scaffold() { _ ->
                Application()
            }
        }
    }
}