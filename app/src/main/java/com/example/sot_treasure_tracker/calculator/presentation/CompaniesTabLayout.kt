package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.presentation.models.TabItem


@Composable
fun CalculatorTabLayout(
    tabItems: List<TabItem> = listOf(
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
    ),
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit
) {

    ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
        tabItems.forEachIndexed { index, tabItem ->
            Tab(
                selected = index == selectedTabIndex,
                onClick = { onTabClick.invoke(index) },
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


}

@Preview(showBackground = true)
@Composable
fun TabLayoutPreview() {
    CalculatorTabLayout(
        selectedTabIndex =  0,
        onTabClick = {  }
    )
}