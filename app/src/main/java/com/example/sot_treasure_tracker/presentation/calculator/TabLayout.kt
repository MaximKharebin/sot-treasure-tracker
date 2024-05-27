package com.example.sot_treasure_tracker.presentation.calculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.R
<<<<<<< Updated upstream:app/src/main/java/com/example/sot_treasure_tracker/calculator/presentation/TabLayout.kt
import com.example.sot_treasure_tracker.calculator.presentation.models.TabItem
import com.example.sot_treasure_tracker.components.presentation.theme.fontSize
import com.example.sot_treasure_tracker.components.presentation.theme.spacing
=======
import com.example.sot_treasure_tracker.presentation.utils.theme.fontSize
>>>>>>> Stashed changes:app/src/main/java/com/example/sot_treasure_tracker/presentation/calculator/TabLayout.kt

private val tabItems = listOf(
    TabItem(
        title = R.string.gold_hoarders,
        unselectedIcon = R.drawable.logo_gh,
        selectedIcon = R.drawable.logo_gh
    ),
    TabItem(
        title = R.string.order_of_souls,
        unselectedIcon = R.drawable.logo_oos,
        selectedIcon = R.drawable.logo_oos
    ),
    TabItem(
        title = R.string.merchant_alliance,
        unselectedIcon = R.drawable.logo_ma,
        selectedIcon = R.drawable.logo_ma
    ),
    TabItem(
        title = R.string.athena_fortune,
        unselectedIcon = R.drawable.logo_af,
        selectedIcon = R.drawable.logo_af
    ),
    TabItem(
        title = R.string.reaper_bones,
        unselectedIcon = R.drawable.logo_rb,
        selectedIcon = R.drawable.logo_rb
    ),
    TabItem(
        title = R.string.other,
        unselectedIcon = R.drawable.logo_br,
        selectedIcon = R.drawable.logo_br
    )
)

@Composable
fun TabLayout(
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit
) {

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
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                MaterialTheme.colorScheme.inverseSurface,
                                shape = RoundedCornerShape(50.dp)
                            )
                            .padding(all = MaterialTheme.spacing.small)
                    )
                else
                    Image(
                        painter = painterResource(id = tabItem.selectedIcon),
                        contentDescription = stringResource(id = tabItem.title),
                        modifier = Modifier
                            .size(32.dp)
                            .background(
                                MaterialTheme.colorScheme.inverseSurface,
                                shape = RoundedCornerShape(50.dp)
                            )
                            .padding(all = MaterialTheme.spacing.small)
                    )
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun TabLayoutPreview() {
    SotTreasureTrackerTheme {
        TabLayout(
            selectedTabIndex = 0,
            onTabClick = { }
        )
    }
}