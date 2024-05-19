package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.presentation.models.TabItem


@Composable
fun CalculatorRoot(
    navController: NavController,
    viewModel: CalculatorViewModel = hiltViewModel()
) {
    Calculator()
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Calculator() {
    val tabItems = listOf(
        TabItem(
            title = "Gold Hoarders",
            unselectedIcon = R.drawable.img_gh_logo,
            selectedIcon = R.drawable.img_gh_logo
        ),
        TabItem(
            title = "Order of Souls",
            unselectedIcon = R.drawable.img_oos_logo,
            selectedIcon = R.drawable.img_oos_logo
        ),
        TabItem(
            title = "Merchant Alliance",
            unselectedIcon = R.drawable.img_ma_logo,
            selectedIcon = R.drawable.img_ma_logo
        ),
        TabItem(
            title = "Athena's Fortune",
            unselectedIcon = R.drawable.img_af_logo,
            selectedIcon = R.drawable.img_af_logo
        ),
        TabItem(
            title = "Reaper's Bones",
            unselectedIcon = R.drawable.img_rb_logo,
            selectedIcon = R.drawable.img_rb_logo
        ),
        TabItem(
            title = "Other",
            unselectedIcon = R.drawable.img_br_logo,
            selectedIcon = R.drawable.img_br_logo
        )
    )

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState { tabItems.size }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress)
            selectedTabIndex = pagerState.currentPage
    }

    Column {
        ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == selectedTabIndex,
                    onClick = { selectedTabIndex = index },
                    text = {
                        if (index == selectedTabIndex)
                            Text(
                                text = tabItem.title,
                                fontWeight = FontWeight.Bold,
                            )
                        else
                            Text(
                                text = tabItem.title,
                                fontWeight = FontWeight.Normal,
                            )
                    },
                    icon = {
                        if (index == selectedTabIndex)
                            Image(
                                painter = painterResource(id = tabItem.selectedIcon),
                                contentDescription = tabItem.title,
                                modifier = Modifier.size(32.dp)
                            )
                        else
                            Image(
                                painter = painterResource(id = tabItem.selectedIcon),
                                contentDescription = tabItem.title,
                                modifier = Modifier.size(28.dp)
                            )
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = tabItems[index].title)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    Calculator()
}