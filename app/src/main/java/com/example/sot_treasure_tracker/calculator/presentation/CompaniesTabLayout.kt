package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.presentation.models.TabItem
import com.example.sot_treasure_tracker.components.presentation.theme.fontSize


@Composable
fun CalculatorTabLayout(
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit
) {
    val tabItems = listOf(
        TabItem(
            title = R.string.gold_hoarders,
            unselectedIcon = R.drawable.img_gh_logo,
            selectedIcon = R.drawable.img_gh_logo
        ),
        TabItem(
            title = R.string.order_of_souls,
            unselectedIcon = R.drawable.img_oos_logo,
            selectedIcon = R.drawable.img_oos_logo
        ),
        TabItem(
            title = R.string.merchant_alliance,
            unselectedIcon = R.drawable.img_ma_logo,
            selectedIcon = R.drawable.img_ma_logo
        ),
        TabItem(
            title = R.string.athena_fortune,
            unselectedIcon = R.drawable.img_af_logo,
            selectedIcon = R.drawable.img_af_logo
        ),
        TabItem(
            title = R.string.reaper_bones,
            unselectedIcon = R.drawable.img_rb_logo,
            selectedIcon = R.drawable.img_rb_logo
        ),
        TabItem(
            title = R.string.other,
            unselectedIcon = R.drawable.img_br_logo,
            selectedIcon = R.drawable.img_br_logo
        )
    )

    tabItems.forEachIndexed { index, tabItem ->
        Tab(
            selected = index == selectedTabIndex,
            onClick = { onTabClick.invoke(index) },
            text = {
                if (index == selectedTabIndex)
                    Text(
                        text = stringResource(id = tabItem.title),
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.fontSize.body
                    )
                else
                    Text(
                        text = stringResource(id = tabItem.title),
                        fontWeight = FontWeight.Normal,
                        fontSize = MaterialTheme.fontSize.label
                    )
            },
            icon = {
                if (index == selectedTabIndex)
                    Image(
                        painter = painterResource(id = tabItem.selectedIcon),
                        contentDescription = stringResource(id = tabItem.title),
                        modifier = Modifier.size(32.dp)
                    )
                else
                    Image(
                        painter = painterResource(id = tabItem.selectedIcon),
                        contentDescription = stringResource(id = tabItem.title),
                        modifier = Modifier.size(28.dp)
                    )
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TabLayoutPreview() {
    CalculatorTabLayout(
        selectedTabIndex = 0,
        onTabClick = { }
    )
}