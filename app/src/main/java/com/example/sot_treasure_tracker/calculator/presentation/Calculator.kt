package com.example.sot_treasure_tracker.calculator.presentation

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.ScreenPresets
import com.example.sot_treasure_tracker.calculator.domain.models.Emissaries
import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem
import com.example.sot_treasure_tracker.components.data.TreasureCatalogInstance
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
    LaunchedEffect(bundle) {
        val ids = bundle?.getIntArray("ids")?.toList() ?: listOf()
        val quantities = bundle?.getIntArray("quantities")?.toList() ?: listOf()
        viewModel.applyPreset(ids, quantities)

        navController.currentBackStackEntry
            ?.savedStateHandle
            ?.remove<Bundle>("bundle")
    }

    val treasureCatalog = viewModel.catalog.collectAsState().value
    val minGoldAmount = viewModel.minGoldAmount.collectAsState().value
    val maxGoldAmount = viewModel.maxGoldAmount.collectAsState().value
    val doubloonsAmount = viewModel.doubloonsAmount.collectAsState().value
    val emissaryValueAmount = viewModel.emissaryValueAmount.collectAsState().value
    val selectedEmissary = viewModel.selectedEmissary.collectAsState().value
    val emissaryGrade = viewModel.emissaryGrade.collectAsState().value
    val selectedTabIndex = viewModel.selectedTabIndex.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value

    val setItemQuantity = { item: CategoryItem, quantity: Int ->
        viewModel.setItemQuantity(item as TreasureItem, quantity)
    }
    val setSelectedEmissary = { index: Int ->
        viewModel.setSelectedEmissary(emissary = Emissaries.entries[index])
    }
    val setSelectedTab = { index: Int ->
        viewModel.setSelectedTab(index = index)
    }
    val setEmissaryGrade = { index: Int ->
        viewModel.setEmissaryGrade(grade = EmissaryGrades.entries[index])
    }
    val navigateToPresets = {
        navController.navigate(ScreenPresets)
    }
    val clearCatalog = {
        viewModel.clearCatalog()
    }


    val pagerState = rememberPagerState { treasureCatalog.size }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress)
            viewModel.setSelectedTab(pagerState.currentPage)
    }

    Calculator(
        treasureCatalog = treasureCatalog,
        minGoldAmount = minGoldAmount,
        maxGoldAmount = maxGoldAmount,
        doubloonsAmount = doubloonsAmount,
        emissaryValueAmount = emissaryValueAmount,
        selectedEmissary = selectedEmissary,
        emissaryGrade = emissaryGrade,
        selectedTabIndex = selectedTabIndex,
        pagerState = pagerState,
        isLoading = isLoading,
        
        setItemQuantity = setItemQuantity,
        setSelectedEmissary = setSelectedEmissary,
        setSelectedTab = setSelectedTab,
        setEmissaryGrade = setEmissaryGrade,
        navigateToPresets = navigateToPresets,
        clearCatalog = clearCatalog
    )
}

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
    pagerState: PagerState,
    isLoading: Boolean,

    setSelectedTab: (Int) -> Unit,
    setItemQuantity: (CategoryItem, Int) -> Unit,
    setSelectedEmissary: (Int) -> Unit,
    setEmissaryGrade: (Int) -> Unit,
    navigateToPresets: () -> Unit,
    clearCatalog: () -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = MaterialTheme.spacing.small)
    ) {
        ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
            TabLayout(
                selectedTabIndex = selectedTabIndex,
                onTabClick = { setSelectedTab.invoke(it) }
            )
        }

        if (!isLoading) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { currentPageIndex ->
                CatalogCategories(
                    modifier = Modifier.fillMaxSize(),
                    categories = treasureCatalog[currentPageIndex],
                    setItemQuantity = setItemQuantity,
                )
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                CircularProgressIndicator()
            }
        }

        Column(
            modifier = Modifier.padding(
                horizontal = MaterialTheme.spacing.medium
            )
        ) {

            CostValues(
                minGoldAmount = minGoldAmount,
                maxGoldAmount = maxGoldAmount,
                doubloonsAmount = doubloonsAmount,
                emissaryValueAmount = emissaryValueAmount,
                doShowAll = true,
                modifier = Modifier.padding(vertical = MaterialTheme.spacing.small)
            )

            Row {
                EmissarySelector(
                    selectedEmissary = selectedEmissary,
                    emissaryGrade = emissaryGrade,
                    setSelectedEmissary = setSelectedEmissary,
                    setEmissaryGrade = setEmissaryGrade,
                    modifier = Modifier.weight(1f)
                )
                ControlButtons(
                    navigateToPresets = navigateToPresets,
                    clearCalculator = clearCatalog
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun CalculatorPreview() {

    val treasureCatalog = TreasureCatalogInstance.catalog
    val minGoldAmount = 0
    val maxGoldAmount = 0
    val doubloonsAmount = 0
    val emissaryValueAmount = 0
    val selectedEmissary = Emissaries.GOLD_HOARDERS
    val emissaryGrade = EmissaryGrades.SECOND_GRADE
    val selectedTabIndex = 0
    val isLoading = false

    val setItemQuantity = { _: CategoryItem, _: Int -> }
    val setSelectedEmissary = { _: Int -> }
    val setSelectedTab = { _: Int -> }
    val setEmissaryGrade = { _: Int -> }
    val navigateToPresets = {  }
    val clearCalculator = {  }

    SotTreasureTrackerTheme {
        Calculator(
            treasureCatalog = treasureCatalog,
            minGoldAmount = minGoldAmount,
            maxGoldAmount = maxGoldAmount,
            doubloonsAmount = doubloonsAmount,
            emissaryValueAmount = emissaryValueAmount,
            selectedTabIndex = selectedTabIndex,
            selectedEmissary = selectedEmissary,
            emissaryGrade = emissaryGrade,
            pagerState = object : PagerState() {
                override val pageCount = 2
            },
            isLoading = isLoading,

            setItemQuantity = setItemQuantity,
            setSelectedEmissary = setSelectedEmissary,
            setEmissaryGrade = setEmissaryGrade,
            navigateToPresets = navigateToPresets,
            clearCatalog = clearCalculator,
            setSelectedTab = setSelectedTab
        )
    }
}
