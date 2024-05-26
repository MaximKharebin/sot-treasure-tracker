package com.example.sot_treasure_tracker.presets.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.domain.models.CatalogCategory
import com.example.sot_treasure_tracker.components.domain.models.CategoryItem
import com.example.sot_treasure_tracker.components.presentation.CatalogCategories
import com.example.sot_treasure_tracker.components.presentation.CostValues
import com.example.sot_treasure_tracker.components.presentation.theme.spacing
import com.example.sot_treasure_tracker.presets.data.PresetsCatalogInstance
import com.example.sot_treasure_tracker.presets.domain.models.PresetItem
import com.example.sot_treasure_tracker.presets.domain.models.PresetReward
import com.example.sot_treasure_tracker.presets.presentation.models.CostValues

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PresetsRoot(
    navController: NavController,
    viewModel: PresetsViewModel = hiltViewModel()
) {

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
                    IconButton(onClick = {
                        navigateToCalculator.invoke(storedTreasureIds, storedTreasureQuantities)
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Check,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Presets(
            presetsCatalog = viewModel.presetCatalog.collectAsState().value,
            minGoldAmount = viewModel.minGoldAmount.collectAsState().value,
            maxGoldAmount = viewModel.maxGoldAmount.collectAsState().value,
            doubloonsAmount = viewModel.doubloonsAmount.collectAsState().value,
            setItemQuantity = { categoryItem, newQuantity ->
                (categoryItem as? PresetItem)?.let {
                    viewModel.setItemQuantity(it, newQuantity)
                }
            },
            calculateValues = { eventRewards ->
                viewModel.getPresetRewardCost(eventRewards)
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
private fun Presets(
    presetsCatalog: List<CatalogCategory>,
    minGoldAmount: Int,
    maxGoldAmount: Int,
    doubloonsAmount: Int,
    calculateValues: (List<PresetReward>) -> CostValues,
    setItemQuantity: (CategoryItem, Int) -> Unit,
    modifier: Modifier = Modifier
) {


    Column(
        modifier = modifier
    ) {

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
                emissaryValueAmount = 0,
                doShowAll = true
            )
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
            minGoldAmount = 10000,
            maxGoldAmount = 500000,
            doubloonsAmount = 2000,
            calculateValues = {
                CostValues(100, 500, 25)
            }
        )
    }
}