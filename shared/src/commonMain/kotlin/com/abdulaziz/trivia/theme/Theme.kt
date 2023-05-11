package com.abdulaziz.trivia.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Green500,
    primaryVariant = MainBackground,
    secondary = Green500,
    background = MainBackground
)

private val LightColorPalette = lightColors(
    primary = Green500,
    primaryVariant = MainBackground,
    secondary = Green500,
    background = MainBackground
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)