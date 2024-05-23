package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.domain.models.Emissaries
import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem
import com.example.sot_treasure_tracker.calculator.presentation.models.DropDownItem

@Composable
fun EmissarySelector(
    selectedEmissary: Emissaries,
    emissaryGrade: EmissaryGrades,
    setSelectedEmissary: (Int) -> Unit,
    setEmissaryGrade: (Int) -> Unit
) {

    val dropDownItems = listOf(
        DropDownItem(
            id = 0,
            title = "Gold Hoarders",
            icon = R.drawable.img_gh_logo
        ),
        DropDownItem(
            id = 1,
            title = "Order of Souls",
            icon = R.drawable.img_oos_logo
        ),
        DropDownItem(
            id = 2,
            title = "Merchant Alliance",
            icon = R.drawable.img_ma_logo
        ),
        DropDownItem(
            id = 3,
            title = "Athena's Fortune",
            icon = R.drawable.img_af_logo
        ),
        DropDownItem(
            id = 4,
            title = "Reaper's Bones",
            icon = R.drawable.img_rb_logo
        ),
        DropDownItem(
            id = 5,
            title = "Guild",
            icon = R.drawable.img_br_logo
        ),
        DropDownItem(
            id = 6,
            title = "Unselect",
            icon = R.drawable.img_br_logo
        ),
    )

    Row {
        EmissaryItem(
            icon = dropDownItems[selectedEmissary.ordinal].icon,
            dropDownItems = dropDownItems,
            onItemClick = { setSelectedEmissary(it.id) })
        Slider(
            value = emissaryGrade.ordinal.toFloat(),
            onValueChange = { setEmissaryGrade.invoke(it.toInt()) },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            valueRange = 0f..4f
        )
    }
}