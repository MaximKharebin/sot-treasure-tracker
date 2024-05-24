package com.example.sot_treasure_tracker.presets.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.components.domain.models.CatalogCategory
import com.example.sot_treasure_tracker.components.domain.models.CategoryItem
import com.example.sot_treasure_tracker.components.presentation.CatalogCategories
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
    val color by viewModel.color.collectAsState()

    Presets(
        color = viewModel.color.collectAsState().value,
        presetsCatalog = viewModel.presetCatalog.collectAsState().value,
        setItemQuantity = { categoryItem, newQuantity ->
            (categoryItem as? PresetItem)?.let {
                viewModel.setItemQuantity(it, newQuantity)
            }
        },
        calculateValues = {
            viewModel.getPresetRewardCost(it)
        }
    )
}

@Composable
private fun Presets(
    presetsCatalog: List<CatalogCategory>,
    calculateValues: (List<PresetReward>) -> CostValues,
    setItemQuantity: (CategoryItem, Int) -> Unit,
    color: Long
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

        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.small
                )
        ) {
            Text(text = "color.toString()")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PresetsPreview() {
    SotTreasureTrackerTheme {
        Presets(
            presetsCatalog = PresetsCatalogInstance.catalog,
            setItemQuantity = { _, _ -> },
            color = 0xFF666666,
            calculateValues = {
                CostValues( 100, 500, 25)
            }
        )
    }
}