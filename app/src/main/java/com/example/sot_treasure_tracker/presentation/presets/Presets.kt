package com.example.sot_treasure_tracker.presentation.presets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.PresetsCatalogInstance
import com.example.sot_treasure_tracker.domain.models.CatalogCategory
import com.example.sot_treasure_tracker.domain.models.CategoryItem
import com.example.sot_treasure_tracker.domain.models.PresetItem
import com.example.sot_treasure_tracker.domain.models.PresetReward
import com.example.sot_treasure_tracker.presentation.presets.models.CostValues
import com.example.sot_treasure_tracker.presentation.utils.CatalogCategories
import com.example.sot_treasure_tracker.presentation.utils.CostValues
import com.example.sot_treasure_tracker.presentation.utils.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PresetsRoot(
    navController: NavController,
    viewModel: PresetsViewModel = hiltViewModel()
) {

    val storedTreasureIds = viewModel.storedTreasureIds.collectAsState().value
    val storedTreasureQuantities = viewModel.storedTreasureQuantities.collectAsState().value

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
                            navigateToCalculator.invoke(
                                storedTreasureIds,
                                storedTreasureQuantities
                            )
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Check,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurface
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
            calculateValues = {
                viewModel.getPresetRewardCost(it)
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
    Column(modifier = modifier) {

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
                doShowPrice = true
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
            },
        )
    }
}