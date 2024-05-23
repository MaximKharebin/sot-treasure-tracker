package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sot_treasure_tracker.calculator.data.catalog_instance.TreasureCatalogInstance
import com.example.sot_treasure_tracker.calculator.domain.models.Emissaries
import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureCategory
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem


@Composable
fun CalculatorRoot(
    navController: NavController,
    viewModel: CalculatorViewModel = hiltViewModel()
) {
    Calculator(
        treasureCatalog = viewModel.treasureCatalog.collectAsState().value,
        minGoldAmount = viewModel.minGoldAmount.collectAsState().value,
        maxGoldAmount = viewModel.maxGoldAmount.collectAsState().value,
        doubloonsAmount = viewModel.doubloonsAmount.collectAsState().value,
        emissaryValueAmount = viewModel.emissaryValueAmount.collectAsState().value,
        selectedEmissary = viewModel.selectedEmissary.collectAsState().value,
        emissaryGrade = viewModel.emissaryGrade.collectAsState().value,
        setTreasureItemQuantity = { treasureItem, newQuantity ->
            viewModel.setTreasureItemQuantity(treasureItem, newQuantity)
        },
        setSelectedEmissary = {
            viewModel.setSelectedEmissary(emissary = Emissaries.entries[it])
        },
        setEmissaryGrade = {
            viewModel.setEmissaryGrade(grade = EmissaryGrades.entries[it])
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Calculator(
    treasureCatalog: List<List<TreasureCategory>>,
    minGoldAmount: Int,
    maxGoldAmount: Int,
    doubloonsAmount: Int,
    emissaryValueAmount: Int,
    selectedEmissary: Emissaries,
    emissaryGrade: EmissaryGrades,
    setTreasureItemQuantity: (TreasureItem, Int) -> Unit,
    setSelectedEmissary: (Int) -> Unit,
    setEmissaryGrade: (Int) -> Unit
) {

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { treasureCatalog.size }

    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress)
            selectedTabIndex = pagerState.currentPage
    }


    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        CalculatorTabLayout(
            selectedTabIndex = selectedTabIndex,
            onTabClick = { selectedTabIndex = it }
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { currentPageIndex ->
            val companyTreasure = treasureCatalog[currentPageIndex]
            TreasureCategoryList(
                treasureCategories = companyTreasure,
                setTreasureItemQuantity = { treasureItem, newQuantity ->
                    setTreasureItemQuantity(treasureItem, newQuantity)
                },
            )
        }

        Column(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            CostValues(
                minGoldAmount = minGoldAmount,
                maxGoldAmount = maxGoldAmount,
                doubloonsAmount = doubloonsAmount,
                emissaryValueAmount = emissaryValueAmount
            )
            EmissarySelector(
                selectedEmissary = selectedEmissary,
                emissaryGrade = emissaryGrade,
                setSelectedEmissary = setSelectedEmissary,
                setEmissaryGrade = setEmissaryGrade
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    Calculator(
        treasureCatalog = TreasureCatalogInstance.catalog,
        minGoldAmount = 10000,
        maxGoldAmount = 500000,
        doubloonsAmount = 2000,
        emissaryValueAmount = 275000,
        selectedEmissary = Emissaries.GOLD_HOARDERS,
        emissaryGrade = EmissaryGrades.SECOND_GRADE,
        setTreasureItemQuantity = { _, _ -> },
        setSelectedEmissary = { },
        setEmissaryGrade = { }
    )
}