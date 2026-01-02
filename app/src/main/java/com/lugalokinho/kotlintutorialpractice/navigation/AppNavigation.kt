package com.lugalokinho.kotlintutorialpractice.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lugalokinho.kotlintutorialpractice.features.business_card.BusinessCardScreen
import com.lugalokinho.kotlintutorialpractice.features.completed_task.CompletedTaskScreen
import com.lugalokinho.kotlintutorialpractice.features.quadrant.QuadrantScreen
import com.lugalokinho.kotlintutorialpractice.features.tutorial.TutorialScreen

enum class Destination(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val contentDescription: String
) {
    TUTORIAL("tutorial", "Tutorial", Icons.Default.Info, "Tutorial"),
    COMPLETED_TASK(
        "completed_task",
        "Tasks",
        Icons.Default.CheckCircle,
        "Completed Task"
    ),
    QUADRANT("quadrant", "Quadrant", Icons.Default.AccountBox, "Quadrant"),
    BUSINESS_CARD("business_card", "Business Card", Icons.Default.Call, "Business Card")
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
                    Destination.TUTORIAL -> TutorialScreen(modifier)
                    Destination.COMPLETED_TASK -> CompletedTaskScreen(modifier)
                    Destination.QUADRANT -> QuadrantScreen(modifier)
                    Destination.BUSINESS_CARD -> BusinessCardScreen(modifier)
                }
            }
        }
    }
}

@Composable
fun AppWithNavigationBar(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = Destination.BUSINESS_CARD
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
    ) { _ ->
        AppNavHost(navController, startDestination, modifier = Modifier)
    }
}