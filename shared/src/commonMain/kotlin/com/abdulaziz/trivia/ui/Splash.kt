package com.abdulaziz.trivia.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulaziz.trivia.navigation.NavigationScreens
import com.abdulaziz.trivia.theme.MainBackground
import moe.tlaster.precompose.navigation.Navigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Splash(navigator: Navigator) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = MainBackground).padding(16.dp)
            .windowInsetsPadding(WindowInsets(top = 20.dp, bottom = 20.dp))
    ) {
        Text(
            "Compose Quiz", modifier = Modifier.fillMaxWidth(),
            style = TextStyle(color = Color.White, fontSize = 50.sp, fontWeight = FontWeight.ExtraBold),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            "Movie and TV: \uD83C\uDFAC\uD83D\uDCFA\uD83C\uDF7F",
            modifier = Modifier.fillMaxWidth().border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(size = 30.dp))
                .clip(RoundedCornerShape(30.dp))
                .clickable {
                    navigator.navigate(NavigationScreens.Quiz.withIndex(index = 0, category = 2))
                }
                .padding(vertical = 8.dp, horizontal = 16.dp),
            style = TextStyle(color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "History: \uD83D\uDCDC\uD83C\uDFF0⚔️",
            modifier = Modifier.fillMaxWidth().border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(size = 30.dp))
                .clip(RoundedCornerShape(30.dp))
                .clickable {
                    navigator.navigate(NavigationScreens.Quiz.withIndex(index = 0, category = 0))
                }
                .padding(vertical = 8.dp, horizontal = 16.dp),
            style = TextStyle(color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "General Knowledge: \uD83D\uDCA1\uD83E\uDDE0\uD83C\uDF1F",
            modifier = Modifier.fillMaxWidth().border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(size = 30.dp))
                .clip(RoundedCornerShape(30.dp))
                .clickable {
                    navigator.navigate(NavigationScreens.Quiz.withIndex(index = 0, category = 3))
                }
                .padding(vertical = 8.dp, horizontal = 16.dp),
            style = TextStyle(color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Geography: \uD83C\uDF0D\uD83D\uDDFA️\uD83C\uDF04",
            modifier = Modifier.fillMaxWidth().border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(size = 30.dp))
                .clip(RoundedCornerShape(30.dp))
                .clickable {
                    navigator.navigate(NavigationScreens.Quiz.withIndex(index = 0, category = 1))
                }
                .padding(vertical = 8.dp, horizontal = 16.dp),
            style = TextStyle(color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)
        )

        Spacer(modifier = Modifier.height(16.dp))
        Spacer(modifier = Modifier.weight(1f))
    }
}