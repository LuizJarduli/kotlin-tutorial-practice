package com.lugalokinho.kotlintutorialpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lugalokinho.kotlintutorialpractice.navigation.AppWithNavigationBar
import com.lugalokinho.kotlintutorialpractice.ui.theme.KotlinTutorialPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTutorialPracticeTheme {
                AppWithNavigationBar()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinTutorialPracticeTheme {
        AppWithNavigationBar()
    }
}
