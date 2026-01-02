package com.lugalokinho.kotlintutorialpractice.features.quadrant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lugalokinho.kotlintutorialpractice.R

@Composable
private fun QuadrantItem(
    title: String, description: String, modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(
            text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = description, textAlign = TextAlign.Justify)
    }
}

@Composable
fun QuadrantScreen(modifier: Modifier = Modifier) {
    val title1 = stringResource(R.string.text_composable)
    val description1 = stringResource(R.string.description_1)
    val title2 = stringResource(R.string.image_composable)
    val description2 = stringResource(R.string.description_2)
    val title3 = stringResource(R.string.row_composable)
    val description3 = stringResource(R.string.description_3)
    val title4 = stringResource(R.string.column_composable)
    val description4 = stringResource(R.string.description_4)

    Column(modifier = modifier.fillMaxSize()) {
        Row(modifier.weight(1f)) {
            QuadrantItem(
                title = title1,
                description = description1,
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFEADDFF))
            )
            QuadrantItem(
                title = title2,
                description = description2,
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFD0BCFF))
            )
        }
        Row(modifier.weight(1f)) {
            QuadrantItem(
                title = title3,
                description = description3,
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFB69DF8))
            )
            QuadrantItem(
                title = title4,
                description = description4,
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFF6EDFF))
            )
        }
    }
}