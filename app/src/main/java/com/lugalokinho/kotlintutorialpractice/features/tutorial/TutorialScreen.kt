package com.lugalokinho.kotlintutorialpractice.features.tutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lugalokinho.kotlintutorialpractice.R

@Composable
private fun TutorialBanner(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(painter = image, contentDescription = null, modifier = modifier)
}

@Composable
private fun TutorialTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title, fontSize = 24.sp, modifier = modifier
    )
}

@Composable
private fun TutorialParagraph(text: String, modifier: Modifier = Modifier) {
    Text(text = text, textAlign = TextAlign.Justify, modifier = modifier)
}

@Composable
fun TutorialScreen(modifier: Modifier = Modifier) {
    val title = stringResource(R.string.jetpack_compose_tutorial_title)
    val firstParagraph = stringResource(R.string.tutorial_first_paragraph)
    val secondParagraph = stringResource(R.string.tutorial_second_paragraph)

    Column(verticalArrangement = Arrangement.Top, modifier = modifier) {
        TutorialBanner(modifier = modifier.fillMaxWidth())
        TutorialTitle(title = title, modifier = Modifier.padding(16.dp))
        TutorialParagraph(
            text = firstParagraph, modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        TutorialParagraph(text = secondParagraph, modifier = Modifier.padding(16.dp))
    }
}