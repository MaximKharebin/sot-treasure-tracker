package com.example.sot_treasure_tracker.presentation.calculator

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.presentation.models.TabItem
import com.example.sot_treasure_tracker.presentation.utils.theme.fontSize

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
                val iconSize = if (index == selectedTabIndex) 48.dp else 32.dp
                EmissaryIcon(
                    drawableId = tabItem.icon,
                    contentDescription = stringResource(id = tabItem.title),
                    modifier = Modifier
                        .size(iconSize)
                        .clip(shape = RoundedCornerShape(50.dp))
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

private val tabItems = listOf(
    TabItem(
        title = R.string.gold_hoarders,
        icon = R.drawable.logo_gh
    ),
    TabItem(
        title = R.string.order_of_souls,
        icon = R.drawable.logo_oos
    ),
    TabItem(
        title = R.string.merchant_alliance,
        icon = R.drawable.logo_ma
    ),
    TabItem(
        title = R.string.athena_fortune,
        icon = R.drawable.logo_af
    ),
    TabItem(
        title = R.string.reaper_bones,
        icon = R.drawable.logo_rb
    ),
    TabItem(
        title = R.string.other,
        icon = R.drawable.logo_br
    )
)