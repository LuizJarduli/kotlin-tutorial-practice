package com.lugalokinho.kotlintutorialpractice.features.completed_task

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lugalokinho.kotlintutorialpractice.R

@Composable
private fun CompletedTaskImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Image(painter = image, contentDescription = null, modifier = modifier)
}

@Composable
private fun CompletedTaskMessage(
    message: String, fontSize: Int, fontWeight: FontWeight, modifier: Modifier = Modifier
) {
    Text(
        text = message, fontSize = fontSize.sp, fontWeight = fontWeight, modifier = modifier
    )
}

@Composable
fun CompletedTaskScreen(modifier: Modifier = Modifier) {
    val message = stringResource(R.string.all_tasks_completed)
    val description = stringResource(R.string.nice_work)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        CompletedTaskImage(modifier = Modifier.padding(bottom = 24.dp))
        CompletedTaskMessage(
            message = message,
            fontSize = 24,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp, top = 24.dp)
        )
        CompletedTaskMessage(
            message = description,
            fontSize = 16,
            fontWeight = FontWeight.Normal,
        )
    }
}