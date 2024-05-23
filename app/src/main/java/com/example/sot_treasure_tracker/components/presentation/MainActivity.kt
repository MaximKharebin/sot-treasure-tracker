package com.example.sot_treasure_tracker.components.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.calculator.presentation.CalculatorRoot
import com.example.sot_treasure_tracker.presets.presentation.Presets
import dagger.hilt.android.AndroidEntryPoint

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
                    SotTreasureCalculatorApp()
                }
            }
        }
    }
}

@Composable
fun SotTreasureCalculatorApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "calculator") {
        composable("calculator") { CalculatorRoot(navController = navController) }
        composable("presets") { Presets() }
    }
}

@Preview(showBackground = true)
@Composable
fun SotTreasureCalculatorAppPreview() {
    val navController = rememberNavController()
    CalculatorRoot(navController = navController)
}