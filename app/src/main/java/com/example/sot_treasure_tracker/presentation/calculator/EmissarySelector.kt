package com.example.sot_treasure_tracker.presentation.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.RemoveCircleOutline
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.domain.models.Emissaries
import com.example.sot_treasure_tracker.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.presentation.utils.theme.spacing
@Composable
fun EmissarySelector(
    selectedEmissary: Emissaries,
    emissaryGrade: EmissaryGrades,
    setSelectedEmissary: (Int) -> Unit,
    setEmissaryGrade: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    val trackColor = when (selectedEmissary) {
        Emissaries.GOLD_HOARDERS -> Color(0xFFF4EB3C)
        Emissaries.MERCHANT_ALLIANCE -> Color(0xFF1394B2)
        Emissaries.ORDER_OF_SOULS -> Color(0xFFB44C84)
        Emissaries.ATHENAS_FORTUNE -> Color(0xFF6CECAB)
        Emissaries.REAPERS_BONES -> Color(0xFFB42414)
        Emissaries.GUILD -> MaterialTheme.colorScheme.secondary
        Emissaries.UNSELECTED -> MaterialTheme.colorScheme.secondary
    }

    Row(
        modifier = modifier
    ) {
        EmissaryDropDownIcon(
            selectedEmissaryIndex = selectedEmissary.ordinal,
            onItemClick = { setSelectedEmissary(it.id) })
        Slider(
            enabled = selectedEmissary != Emissaries.UNSELECTED,
            value = emissaryGrade.ordinal.toFloat(),
            onValueChange = { setEmissaryGrade.invoke(it.toInt()) },
            colors = SliderDefaults.colors(
                thumbColor = trackColor,
                activeTrackColor = trackColor,
                inactiveTrackColor = MaterialTheme.colorScheme.surface,
                inactiveTickColor = MaterialTheme.colorScheme.inverseSurface,
                activeTickColor = MaterialTheme.colorScheme.inverseSurface,
            ),
            steps = 3,
            valueRange = 0f..4f,
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.surfaceDim,
                    shape = RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp)
                )
                .padding(horizontal = MaterialTheme.spacing.medium)
                .weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmissarySelectorPreview() {
    SotTreasureTrackerTheme {
        EmissarySelector(
            selectedEmissary = Emissaries.GOLD_HOARDERS,
            emissaryGrade = EmissaryGrades.SECOND_GRADE,
            setSelectedEmissary = { },
            setEmissaryGrade = { },
        )
    }
}