package com.abdulaziz.trivia.navigation

import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import com.abdulaziz.trivia.ui.Quiz
import com.abdulaziz.trivia.ui.Result
import com.abdulaziz.trivia.ui.Splash
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition

@Composable
fun SetupNavGraph(
) {
    val navHostController = rememberNavigator()
    NavHost(
        navigator = navHostController,
        // Navigation transition for the scenes in this NavHost, this is optional
        navTransition = NavTransition(createTransition = slideIn(initialOffset = { IntOffset(100, 0) }),
            resumeTransition = slideIn(initialOffset = { IntOffset(100, 0) }),
            pauseTransition = slideOut(targetOffset = { IntOffset(-0, 0) }),
            destroyTransition = slideOut(targetOffset = { IntOffset(-0, 0) })
        ),
        // The start destination
        initialRoute = NavigationScreens.Splash.route,

        ) {
        scene(
            // Scene's route path
            route = NavigationScreens.Splash.route,
        ) {
            Splash(navHostController)
        }
        scene(
            // Scene's route path
            route = NavigationScreens.Quiz.route,
        ) {
            Quiz(navHostController, it.path<Int>("category") ?: 0)
        }
        scene(
            // Scene's route path
            route = NavigationScreens.Result.route,
        ) {
            Result(navHostController, it.path<Int>("correct") ?: 0)
        }

    }
}