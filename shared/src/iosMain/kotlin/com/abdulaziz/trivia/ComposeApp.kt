package com.abdulaziz.trivia

import com.abdulaziz.trivia.navigation.SetupNavGraph
import moe.tlaster.precompose.PreComposeApplication
import platform.UIKit.UIViewController

fun mainViewController(): UIViewController {
    val preComposeApplication = PreComposeApplication("Trivia") {
        SetupNavGraph()
    }
    return preComposeApplication
}