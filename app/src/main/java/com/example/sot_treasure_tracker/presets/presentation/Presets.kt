package com.example.sot_treasure_tracker.presets.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.SotTreasureTrackerTheme
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
            navController.navigate(
                ScreenCalculator(
                    treasureIds = ids,
                    treasureQuantities = quantities
                )
            )
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
                emissaryValueAmount = 0
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