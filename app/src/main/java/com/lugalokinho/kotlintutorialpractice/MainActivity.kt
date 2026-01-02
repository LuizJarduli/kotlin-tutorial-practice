package com.lugalokinho.kotlintutorialpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lugalokinho.kotlintutorialpractice.ui.theme.KotlinTutorialPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTutorialPracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CompletedTask(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// [START tutorial_practice]
@Composable
fun TutorialBanner(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(painter = image, contentDescription = null, modifier = modifier)
}

@Composable
fun TutorialTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 24.sp,
        modifier = modifier
    )
}

@Composable
fun TutorialParagraph(text: String, modifier: Modifier = Modifier) {
    Text(text = text, textAlign = TextAlign.Justify, modifier = modifier)
}

@Composable
fun Tutorial(modifier: Modifier = Modifier) {
    val title = stringResource(R.string.jetpack_compose_tutorial_title)
    val firstParagraph =
        stringResource(R.string.tutorial_first_paragraph)
    val secondParagraph =
        stringResource(R.string.tutorial_second_paragraph)

    Column(verticalArrangement = Arrangement.Top, modifier = modifier) {
        TutorialBanner(modifier = modifier.fillMaxWidth())
        TutorialTitle(title = title, modifier.padding(16.dp))
        TutorialParagraph(
            text = firstParagraph,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        TutorialParagraph(text = secondParagraph, modifier.padding(16.dp))
    }
}

// [END tutorial_practice]

// [START completed_task_practice]

@Composable
fun CompletedTaskImage(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.ic_task_completed)
    Image(painter = image, contentDescription = null, modifier = modifier)
}

@Composable
fun CompletedTaskMessage(
    message: String,
    fontSize: Int,
    fontWeight: FontWeight,
    modifier: Modifier = Modifier
) {
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        modifier = modifier
    )
}

@Composable
fun CompletedTask(modifier: Modifier = Modifier) {
    val message = "All tasks completed"
    val description = "Nice work!"

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        CompletedTaskImage(modifier = modifier.padding(bottom = 24.dp))
        CompletedTaskMessage(
            message = message,
            fontSize = 24,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(bottom = 8.dp, top = 24.dp)
        )
        CompletedTaskMessage(
            message = description,
            fontSize = 16,
            fontWeight = FontWeight.Normal,
        )
    }
}

// [END completed_task_practice]

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinTutorialPracticeTheme {
        CompletedTask()
    }
}