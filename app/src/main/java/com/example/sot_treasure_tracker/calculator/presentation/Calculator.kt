package com.example.sot_treasure_tracker.calculator.presentation

import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.bundleOf
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.toRoute
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.ScreenCalculator
import com.example.sot_treasure_tracker.ScreenPresets
import com.example.sot_treasure_tracker.components.data.TreasureCatalogInstance
import com.example.sot_treasure_tracker.calculator.domain.models.Emissaries
import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem
import com.example.sot_treasure_tracker.components.domain.models.CatalogCategory
import com.example.sot_treasure_tracker.components.domain.models.CategoryItem
import com.example.sot_treasure_tracker.components.presentation.CatalogCategories
import com.example.sot_treasure_tracker.components.presentation.CostValues
import com.example.sot_treasure_tracker.components.presentation.theme.spacing


@Composable
fun CalculatorRoot(
    navController: NavController,
    navBackStackEntry: NavBackStackEntry,
    viewModel: CalculatorViewModel = hiltViewModel()
) {

    val bundle = remember { navBackStackEntry.savedStateHandle.get<Bundle>("bundle") }
    val ids = remember(bundle) { bundle?.getIntArray("ids")?.toList() ?: listOf() }
    val quantities = remember(bundle) { bundle?.getIntArray("quantities")?.toList() ?: listOf() }

    LaunchedEffect(bundle) {
        viewModel.applyPreset(ids, quantities)
        navController.currentBackStackEntry
            ?.savedStateHandle
            ?.remove<Bundle>("bundle")
    }

    Calculator(
        treasureCatalog = viewModel.catalog.collectAsState().value,
        minGoldAmount = viewModel.minGoldAmount.collectAsState().value,
        maxGoldAmount = viewModel.maxGoldAmount.collectAsState().value,
        doubloonsAmount = viewModel.doubloonsAmount.collectAsState().value,
        emissaryValueAmount = viewModel.emissaryValueAmount.collectAsState().value,
        selectedEmissary = viewModel.selectedEmissary.collectAsState().value,
        emissaryGrade = viewModel.emissaryGrade.collectAsState().value,
        selectedTabIndex = viewModel.selectedTabIndex.collectAsState().value,
        setItemQuantity = { categoryItem, newQuantity ->
            (categoryItem as? TreasureItem)?.let {
                viewModel.setItemQuantity(it, newQuantity)
            }
        },
        setSelectedEmissary = {
            viewModel.setSelectedEmissary(emissary = Emissaries.entries[it])
        },
        setSelectedTabIndex = {
            viewModel.setSelectedTabIndex(index = it)
        },
        setEmissaryGrade = {
            viewModel.setEmissaryGrade(grade = EmissaryGrades.entries[it])
        },
        navigateToPresets = { navController.navigate(ScreenPresets) },
        clearCalculator = { viewModel.clearCalculator() }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun Calculator(
    treasureCatalog: List<List<CatalogCategory>>,
    minGoldAmount: Int,
    maxGoldAmount: Int,
    doubloonsAmount: Int,
    emissaryValueAmount: Int,
    selectedEmissary: Emissaries,
    emissaryGrade: EmissaryGrades,
    selectedTabIndex: Int,
    setSelectedTabIndex: (Int) -> Unit,
    setItemQuantity: (CategoryItem, Int) -> Unit,
    setSelectedEmissary: (Int) -> Unit,
    setEmissaryGrade: (Int) -> Unit,
    navigateToPresets: () -> Unit,
    clearCalculator: () -> Unit
) {
    val pagerState = rememberPagerState { treasureCatalog.size }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress)
            setSelectedTabIndex.invoke(pagerState.currentPage)
    }


    Column(
        modifier = Modifier.padding(vertical = MaterialTheme.spacing.small)
    ) {
        ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
            TabLayout(
                selectedTabIndex = selectedTabIndex,
                onTabClick = { setSelectedTabIndex.invoke(it) }
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { currentPageIndex ->
            CatalogCategories(
                categories = treasureCatalog[currentPageIndex],
                setItemQuantity = setItemQuantity,
            )
        }

        Column(
            modifier = Modifier.padding(
                horizontal = MaterialTheme.spacing.medium
            )
        ) {
            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

            CostValues(
                minGoldAmount = minGoldAmount,
                maxGoldAmount = maxGoldAmount,
                doubloonsAmount = doubloonsAmount,
                emissaryValueAmount = emissaryValueAmount
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

            EmissarySelector(
                selectedEmissary = selectedEmissary,
                emissaryGrade = emissaryGrade,
                setSelectedEmissary = setSelectedEmissary,
                setEmissaryGrade = setEmissaryGrade,
                navigateToPresets = navigateToPresets,
                clearCalculator = clearCalculator,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CalculatorPreview() {
    SotTreasureTrackerTheme {
        Calculator(
            treasureCatalog = TreasureCatalogInstance.catalog,
            minGoldAmount = 10000,
            maxGoldAmount = 500000,
            doubloonsAmount = 2000,
            emissaryValueAmount = 275000,
            selectedTabIndex = 0,
            selectedEmissary = Emissaries.GOLD_HOARDERS,
            emissaryGrade = EmissaryGrades.SECOND_GRADE,
            setItemQuantity = { _, _ -> },
            setSelectedEmissary = { },
            setEmissaryGrade = { },
            navigateToPresets = { },
            clearCalculator = { },
            setSelectedTabIndex = { }
        )
    }
}