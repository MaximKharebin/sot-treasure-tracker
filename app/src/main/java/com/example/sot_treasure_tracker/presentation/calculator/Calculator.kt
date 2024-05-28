package com.example.sot_treasure_tracker.presentation.calculator

import android.os.Bundle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.sot_treasure_tracker.data.treasure.TreasureCatalogInstance
import com.example.sot_treasure_tracker.domain.models.CatalogCategory
import com.example.sot_treasure_tracker.domain.models.CategoryItem
import com.example.sot_treasure_tracker.domain.models.Emissary
import com.example.sot_treasure_tracker.domain.models.EmissaryGrade
import com.example.sot_treasure_tracker.domain.models.TreasureItem
import com.example.sot_treasure_tracker.presentation.ScreenPresets
import com.example.sot_treasure_tracker.presentation.utils.CatalogCategories
import com.example.sot_treasure_tracker.presentation.utils.CostValues
import com.example.sot_treasure_tracker.presentation.utils.theme.spacing


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
        (item as? TreasureItem)?.let {
            viewModel.setItemQuantity(it, quantity)
        }
    }
    val setSelectedEmissary = { index: Int ->
        viewModel.setSelectedEmissary(emissary = Emissary.entries[index])
    }
    val setSelectedTabIndex = { index: Int ->
        viewModel.setSelectedTabIndex(index = index)
    }
    val setEmissaryGrade = { index: Int ->
        viewModel.setEmissaryGrade(grade = EmissaryGrade.entries[index])
    }
    val navigateToPresets = { navController.navigate(ScreenPresets) }
    val clearCalculator = { viewModel.clearCalculator() }


    val pagerState = rememberPagerState { treasureCatalog.size }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress)
            setSelectedTabIndex.invoke(pagerState.currentPage)
    }

    Calculator(
        treasureCatalog = treasureCatalog,
        pagerState = pagerState,
        minGoldAmount = minGoldAmount,
        maxGoldAmount = maxGoldAmount,
        doubloonsAmount = doubloonsAmount,
        emissaryValueAmount = emissaryValueAmount,
        selectedEmissary = selectedEmissary,
        emissaryGrade = emissaryGrade,
        selectedTabIndex = selectedTabIndex,
        isLoading = isLoading,
        setItemQuantity = { item, quantity -> setItemQuantity.invoke(item, quantity) },
        setSelectedEmissary = { index -> setSelectedEmissary.invoke(index) },
        setSelectedTabIndex = { index -> setSelectedTabIndex.invoke(index) },
        setEmissaryGrade = { index -> setEmissaryGrade.invoke(index) },
        navigateToPresets = { navigateToPresets.invoke() },
        clearCalculator = { clearCalculator.invoke() }
    )
}

@Composable
private fun Calculator(
    treasureCatalog: List<List<CatalogCategory>>,
    pagerState: PagerState,
    minGoldAmount: Int,
    maxGoldAmount: Int,
    doubloonsAmount: Int,
    emissaryValueAmount: Int,
    selectedEmissary: Emissary,
    emissaryGrade: EmissaryGrade,
    selectedTabIndex: Int,
    isLoading: Boolean,

    setSelectedTabIndex: (Int) -> Unit,
    setItemQuantity: (CategoryItem, Int) -> Unit,
    setSelectedEmissary: (Int) -> Unit,
    setEmissaryGrade: (Int) -> Unit,
    navigateToPresets: () -> Unit,
    clearCalculator: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(vertical = MaterialTheme.spacing.small)
    ) {
        ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
            TabLayout(
                selectedTabIndex = selectedTabIndex,
                onTabClick = { setSelectedTabIndex.invoke(it) }
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
                doShowPrice = true,
                doShowEmissaryValue = true,
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
                    clearCalculator = clearCalculator,
                    modifier = Modifier.padding(start = MaterialTheme.spacing.small)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CalculatorPreview() {

    val treasureCatalog = TreasureCatalogInstance.catalog
    val pagerState = object : PagerState() {
        override val pageCount: Int = treasureCatalog.size
    }
    val minGoldAmount = 10000
    val maxGoldAmount = 500000
    val doubloonsAmount = 2000
    val emissaryValueAmount = 275000
    val selectedEmissary = Emissary.GOLD_HOARDERS
    val emissaryGrade = EmissaryGrade.SECOND_GRADE
    val selectedTabIndex = 0
    val isLoading = false
    val setItemQuantity = { _: CategoryItem, _: Int -> }
    val setSelectedEmissary = { }
    val setSelectedTabIndex = { }
    val setEmissaryGrade = { }
    val navigateToPresets = { }
    val clearCalculator = { }

    SotTreasureTrackerTheme {
        Calculator(
            treasureCatalog = treasureCatalog,
            pagerState = pagerState,
            minGoldAmount = minGoldAmount,
            maxGoldAmount = maxGoldAmount,
            doubloonsAmount = doubloonsAmount,
            emissaryValueAmount = emissaryValueAmount,
            selectedTabIndex = selectedTabIndex,
            selectedEmissary = selectedEmissary,
            emissaryGrade = emissaryGrade,
            isLoading = isLoading,
            setItemQuantity = { p1, p2 -> setItemQuantity.invoke(p1, p2) },
            setSelectedEmissary = { setSelectedEmissary.invoke() },
            setEmissaryGrade = { setEmissaryGrade.invoke() },
            navigateToPresets = { navigateToPresets.invoke() },
            clearCalculator = { clearCalculator.invoke() },
            setSelectedTabIndex = { setSelectedTabIndex.invoke() }
        )
    }
}