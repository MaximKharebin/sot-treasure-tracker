package com.example.sot_treasure_tracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.presentation.calculator.CalculatorRoot
import com.example.sot_treasure_tracker.presentation.presets.PresetsRoot
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SotTreasureTrackerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenCalculator()
                    ) {
                        composable<ScreenCalculator> {
                            CalculatorRoot(navController = navController, navBackStackEntry = it)
                        }
                        composable<ScreenPresets> {
                            PresetsRoot(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Serializable
data class ScreenCalculator(
    val treasureIds: List<Int> = listOf(),
    val treasureQuantities: List<Int> = listOf()
)

@Serializable
object ScreenPresets