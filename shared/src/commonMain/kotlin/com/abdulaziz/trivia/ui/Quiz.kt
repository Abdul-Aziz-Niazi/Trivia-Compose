package com.abdulaziz.trivia.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.abdulaziz.trivia.data.Question
import com.abdulaziz.trivia.debugLog
import com.abdulaziz.trivia.navigation.NavigationScreens
import com.abdulaziz.trivia.theme.AppStyles
import com.abdulaziz.trivia.theme.Green200
import com.abdulaziz.trivia.theme.MainBackground
import com.abdulaziz.trivia.ui.components.AnswerButton
import com.abdulaziz.trivia.usecase.LocalUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.PopUpTo

@Composable
fun Quiz(navHostController: Navigator, category: Int) {
    val onSelect = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    var correctAnswer by remember { mutableStateOf(0) }
    var listOfQuestions = listOf<Question>()
    var currentPosition by remember { mutableStateOf(0) }
    var randomPosition by remember { mutableStateOf(0) }
    listOfQuestions = LocalUseCase().getAllTrivia(
        when (category) {
            0 -> "History"
            1 -> "Geography"
            2 -> "Entertainment"
            3 -> "General Knowledge"
            else -> "History"
        }
    )

    fun onAnswerSelected(text: String) {
        onSelect.value = text
        scope.launch {
            delay(200)
            onSelect.value = ""
            currentPosition += 1
            randomPosition = (0..3).random()

        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(
            modifier = Modifier.fillMaxWidth().weight(1f).background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Green200,
                        MainBackground
                    )
                )
            )
        )
        Spacer(modifier = Modifier.fillMaxWidth().weight(1f).background(Color.White))
    }

    Row(
        modifier = Modifier.fillMaxWidth().height(100.dp).padding(vertical = 8.dp, horizontal = 4.dp).windowInsetsPadding(WindowInsets(top = 34.dp)),
    ) {
        repeat(10) {
            Spacer(
                modifier = Modifier.weight(1f).height(8.dp).clip(RoundedCornerShape(corner = CornerSize(8.dp)))
                    .background(Color.White.copy(alpha = if (it < currentPosition) 1f else 0.5f))
            )
            Spacer(modifier = Modifier.width(2.dp))
        }
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column(
            modifier = Modifier.shadow(elevation = 8.dp).fillMaxHeight(0.8f).fillMaxWidth(0.9f)
                .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
                .background(Color.White).padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (currentPosition >= 10) {
                debugLog("Correct Answers: $correctAnswer")
                toResults(navHostController, correctAnswer)
            } else {
                val question = listOfQuestions[currentPosition]
                question.incorrectAnswers.add(randomPosition, question.correctAnswer)

                val questionText = question.questionText
                val optionList = question.incorrectAnswers

                Row(modifier = Modifier.fillMaxWidth()) {
                    Icon(Icons.Outlined.ArrowBack, "",
                        tint = Color.Black, modifier = Modifier
                            .clip(RoundedCornerShape(percent = 100)).clickable {
                                navHostController.popBackStack()
                            }
                    )
                }

                Text(text = questionText, style = AppStyles.textSubtitle, modifier = Modifier.fillMaxWidth().padding(top = 30.dp), textAlign = TextAlign.Start)

                Spacer(modifier = Modifier.weight(1f))

                AnswerButton(
                    onSelect,
                    optionList[0],
                    isCorrect = optionList[0] == question.correctAnswer,
                    onAnswerListener = object : OnAnswerClicked {
                        override fun onAnswerSelected(clicked: Boolean, text: String) {
                            if (text == question.correctAnswer)
                                correctAnswer++
                            onAnswerSelected(text)
                        }
                    })
                AnswerButton(
                    onSelect,
                    optionList[1],
                    isCorrect = optionList[1] == question.correctAnswer,
                    onAnswerListener = object : OnAnswerClicked {
                        override fun onAnswerSelected(clicked: Boolean, text: String) {
                            if (text == question.correctAnswer)
                                correctAnswer++
                            onAnswerSelected(text)
                        }
                    })
                AnswerButton(
                    onSelect,
                    optionList[2],
                    isCorrect = optionList[2] == question.correctAnswer,
                    onAnswerListener = object : OnAnswerClicked {
                        override fun onAnswerSelected(clicked: Boolean, text: String) {
                            if (text == question.correctAnswer)
                                correctAnswer++
                            onAnswerSelected(text)
                        }
                    })
                AnswerButton(
                    onSelect,
                    optionList[3],
                    isCorrect = optionList[3] == question.correctAnswer,
                    onAnswerListener = object : OnAnswerClicked {
                        override fun onAnswerSelected(clicked: Boolean, text: String) {
                            if (text == question.correctAnswer)
                                correctAnswer++
                            onAnswerSelected(text)
                        }
                    })
            }

        }
    }

}

private fun toResults(navHostController: Navigator, correctAnswerCount: Int) {
    navHostController.navigate(
        NavigationScreens.Result.withResult(correctAnswerCount),
        options = NavOptions(popUpTo = PopUpTo.First(inclusive = false))
    )
}

suspend fun shuffleOptions(question: Question): List<String> {
    return question.incorrectAnswers.shuffled()
}

interface OnAnswerClicked {
    fun onAnswerSelected(clicked: Boolean, text: String): Unit
}

