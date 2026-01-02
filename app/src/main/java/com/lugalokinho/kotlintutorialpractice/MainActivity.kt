package com.lugalokinho.kotlintutorialpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lugalokinho.kotlintutorialpractice.ui.theme.KotlinTutorialPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinTutorialPracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppWithNavigationBar()
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
        text = title, fontSize = 24.sp, modifier = modifier
    )
}

@Composable
fun TutorialParagraph(text: String, modifier: Modifier = Modifier) {
    Text(text = text, textAlign = TextAlign.Justify, modifier = modifier)
}

@Composable
fun Tutorial(modifier: Modifier = Modifier) {
    val title = stringResource(R.string.jetpack_compose_tutorial_title)
    val firstParagraph = stringResource(R.string.tutorial_first_paragraph)
    val secondParagraph = stringResource(R.string.tutorial_second_paragraph)

    Column(verticalArrangement = Arrangement.Top, modifier = modifier) {
        TutorialBanner(modifier = modifier.fillMaxWidth())
        TutorialTitle(title = title, modifier.padding(16.dp))
        TutorialParagraph(
            text = firstParagraph, modifier = modifier.padding(start = 16.dp, end = 16.dp)
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
    message: String, fontSize: Int, fontWeight: FontWeight, modifier: Modifier = Modifier
) {
    Text(
        text = message, fontSize = fontSize.sp, fontWeight = fontWeight, modifier = modifier
    )
}

@Composable
fun CompletedTask(modifier: Modifier = Modifier) {
    val message = stringResource(R.string.all_tasks_completed)
    val description = stringResource(R.string.nice_work)

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

// [START quadrant_practice]

@Composable
fun QuadrantItem(
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
fun Quadrant(modifier: Modifier = Modifier) {
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

// [END quadrant_practice]

// [START navigation_host]

enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    TUTORIAL("tutorial", "Tutorial", Icons.Default.Info, "Tutorial"),
    COMPLETED_TASK("completed_task", "Completed Task", Icons.Default.CheckCircle, "Completed Task"),
    QUADRANT("quadrant", "Quadrant", Icons.Default.AccountBox, "Quadrant")
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController,
        startDestination = startDestination.route
    ) {
        Destination.entries.forEach { destination ->
            composable(destination.route) {
                when (destination) {
                    Destination.TUTORIAL -> Tutorial()
                    Destination.COMPLETED_TASK -> CompletedTask()
                    Destination.QUADRANT -> Quadrant()
                }
            }
        }
    }
}

@Composable
fun AppWithNavigationBar(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = Destination.TUTORIAL
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedDestination == index,
                        onClick = {
                            navController.navigate(route = destination.route)
                            selectedDestination = index
                        },
                        icon = {
                            Icon(
                                destination.icon,
                                contentDescription = destination.contentDescription
                            )
                        },
                        label = { Text(destination.label) }
                    )
                }
            }
        }
    ) { contentPadding ->
        AppNavHost(navController, startDestination, modifier = Modifier.padding(contentPadding))
    }
}

// [END navigation_host]

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinTutorialPracticeTheme {
        AppWithNavigationBar()
    }
}