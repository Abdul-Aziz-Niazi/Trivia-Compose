package com.abdulaziz.trivia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.abdulaziz.trivia.theme.Green200
import com.abdulaziz.trivia.ui.OnAnswerClicked


@Composable
fun AnswerButton(onAnswerSelected: MutableState<String>, text: String, isCorrect: Boolean, onAnswerListener: OnAnswerClicked) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(30.dp))
            .clickable {
                onAnswerListener.onAnswerSelected(true, text)
            }
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(30.dp))
            .background(getBackgroundColor(onAnswerSelected, text, isCorrect))
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text, color = if (isSelected(onAnswerSelected, text)) Color.White else Color.Black)
    }
    Spacer(modifier = Modifier.height(16.dp))
}

private fun getBackgroundColor(
    onAnswerSelected: MutableState<String>,
    text: String,
    isCorrect: Boolean
) =
    if (isSelected(onAnswerSelected, text) && isCorrect) Green200 else if (!isCorrect && isSelected(
            onAnswerSelected,
            text
        )
    ) Color.Red else Color.White

private fun isSelected(onAnswerSelected:MutableState<String>, text: String) =
    onAnswerSelected.value.isNotEmpty() && onAnswerSelected.value == text