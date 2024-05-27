package com.example.sot_treasure_tracker.presentation.presets

import androidx.compose.foundation.layout.Column
<<<<<<< Updated upstream:app/src/main/java/com/example/sot_treasure_tracker/presets/presentation/Presets.kt
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
=======
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
>>>>>>> Stashed changes:app/src/main/java/com/example/sot_treasure_tracker/presentation/presets/Presets.kt
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
<<<<<<< Updated upstream:app/src/main/java/com/example/sot_treasure_tracker/presets/presentation/Presets.kt
=======
import androidx.compose.material3.TextButton
>>>>>>> Stashed changes:app/src/main/java/com/example/sot_treasure_tracker/presentation/presets/Presets.kt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.SotTreasureTrackerTheme
<<<<<<< Updated upstream:app/src/main/java/com/example/sot_treasure_tracker/presets/presentation/Presets.kt
import com.example.sot_treasure_tracker.ScreenCalculator
import com.example.sot_treasure_tracker.components.domain.models.CatalogCategory
import com.example.sot_treasure_tracker.components.domain.models.CategoryItem
import com.example.sot_treasure_tracker.components.presentation.CatalogCategories
import com.example.sot_treasure_tracker.components.presentation.CostValues
import com.example.sot_treasure_tracker.components.presentation.theme.spacing
import com.example.sot_treasure_tracker.presets.data.PresetsCatalogInstance
import com.example.sot_treasure_tracker.presets.domain.models.PresetItem
import com.example.sot_treasure_tracker.presets.domain.models.PresetReward
import com.example.sot_treasure_tracker.presets.presentation.models.CostValues
=======
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.domain.models.CatalogCategory
import com.example.sot_treasure_tracker.domain.models.CategoryItem
import com.example.sot_treasure_tracker.presentation.utils.CatalogCategories
import com.example.sot_treasure_tracker.presentation.utils.CostValues
import com.example.sot_treasure_tracker.presentation.utils.theme.spacing
import com.example.sot_treasure_tracker.data.presets.PresetsCatalogInstance
import com.example.sot_treasure_tracker.domain.models.PresetItem
import com.example.sot_treasure_tracker.domain.models.PresetReward
import com.example.sot_treasure_tracker.presentation.presets.models.CostValues
>>>>>>> Stashed changes:app/src/main/java/com/example/sot_treasure_tracker/presentation/presets/Presets.kt

@Composable
fun PresetsRoot(
    navController: NavController,
    viewModel: PresetsViewModel = hiltViewModel()
) {
    Presets(
        presetsCatalog = viewModel.presetCatalog.collectAsState().value,
        storedTreasureIds = viewModel.storedTreasureIds.collectAsState().value,
        storedTreasureQuantities = viewModel.storedTreasureQuantities.collectAsState().value,
        minGoldAmount = viewModel.minGoldAmount.collectAsState().value,
        maxGoldAmount = viewModel.maxGoldAmount.collectAsState().value,
        doubloonsAmount = viewModel.doubloonsAmount.collectAsState().value,
        setItemQuantity = { categoryItem, newQuantity ->
            (categoryItem as? PresetItem)?.let {
                viewModel.setItemQuantity(it, newQuantity)
            }
        },
        calculateValues = {
            viewModel.getPresetRewardCost(it)
        },
        navigateToCalculator = { ids, quantities ->

<<<<<<< Updated upstream:app/src/main/java/com/example/sot_treasure_tracker/presets/presentation/Presets.kt
            val bundle = bundleOf(
                "ids" to ids.toIntArray(),
                "quantities" to quantities.toIntArray()
=======
    val navigateToCalculator = { ids: List<Int>, quantities: List<Int> ->

        val bundle = bundleOf(
            "ids" to ids.toIntArray(),
            "quantities" to quantities.toIntArray()
        )

        navController.previousBackStackEntry
            ?.savedStateHandle
            ?.set("bundle", bundle)
        navController.popBackStack()
    }

    val storedTreasureIds = viewModel.storedTreasureIds.collectAsState().value
    val storedTreasureQuantities = viewModel.storedTreasureQuantities.collectAsState().value


    Scaffold(
        bottomBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.presets))
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = null
                        )
                    }

                },
                actions = {
                    TextButton(
                        onClick = {
                            navigateToCalculator.invoke(storedTreasureIds, storedTreasureQuantities)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Check,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
>>>>>>> Stashed changes:app/src/main/java/com/example/sot_treasure_tracker/presentation/presets/Presets.kt
            )

            navController.previousBackStackEntry
                ?.savedStateHandle
                ?.set("bundle", bundle)
            navController.popBackStack()
        }
    )
}

@Composable
private fun Presets(
    presetsCatalog: List<CatalogCategory>,
    storedTreasureIds: List<Int>,
    storedTreasureQuantities: List<Int>,
    minGoldAmount: Int,
    maxGoldAmount: Int,
    doubloonsAmount: Int,
    calculateValues: (List<PresetReward>) -> CostValues,
    setItemQuantity: (CategoryItem, Int) -> Unit,
    navigateToCalculator: (List<Int>, List<Int>) -> Unit
) {
    Column {

        CatalogCategories(
            modifier = Modifier.weight(1f),
            categories = presetsCatalog,
            setItemQuantity = { categoryItem, newQuantity ->
                setItemQuantity(categoryItem, newQuantity)
            },
            calculateValues = calculateValues
        )

        Column(
            modifier = Modifier.padding(
                horizontal = MaterialTheme.spacing.medium,
                vertical = MaterialTheme.spacing.small
            )
        ) {
            CostValues(
                minGoldAmount = minGoldAmount,
                maxGoldAmount = maxGoldAmount,
                doubloonsAmount = doubloonsAmount,
<<<<<<< Updated upstream:app/src/main/java/com/example/sot_treasure_tracker/presets/presentation/Presets.kt
                emissaryValueAmount = 0
=======
                emissaryValueAmount = 0,
                doShowPrice = true
>>>>>>> Stashed changes:app/src/main/java/com/example/sot_treasure_tracker/presentation/presets/Presets.kt
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

            Button(
                onClick = { navigateToCalculator(storedTreasureIds, storedTreasureQuantities) },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Apply preset")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PresetsPreview() {
    SotTreasureTrackerTheme {
        Presets(
            presetsCatalog = PresetsCatalogInstance.catalog,
            storedTreasureIds = listOf(),
            storedTreasureQuantities = listOf(),
            setItemQuantity = { _, _ -> },
            minGoldAmount = 10000,
            maxGoldAmount = 500000,
            doubloonsAmount = 2000,
            calculateValues = {
                CostValues(100, 500, 25)
            },
            navigateToCalculator = { _, _ -> }
        )
    }
}