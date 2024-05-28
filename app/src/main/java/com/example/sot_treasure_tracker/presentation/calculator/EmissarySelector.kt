package com.example.sot_treasure_tracker.presentation.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.domain.models.Emissary
import com.example.sot_treasure_tracker.domain.models.EmissaryGrade
import com.example.sot_treasure_tracker.presentation.utils.theme.spacing
@Composable
fun EmissarySelector(
    selectedEmissary: Emissary,
    emissaryGrade: EmissaryGrade,
    setSelectedEmissary: (Int) -> Unit,
    setEmissaryGrade: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        EmissaryDropDownIcon(
            selectedEmissaryIndex = selectedEmissary.ordinal,
            onDropDownItemClick = { setSelectedEmissary(it.id) },
            modifier = Modifier
                .clip(shape = RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp))
        )
        Slider(
            steps = 3,
            value = emissaryGrade.ordinal.toFloat(),
            valueRange = 0f..4f,
            onValueChange = { setEmissaryGrade.invoke(it.toInt()) },
            enabled = selectedEmissary != Emissary.UNSELECTED,
            colors = SliderDefaults.colors(
                thumbColor = trackColor(selectedEmissary),
                activeTrackColor = trackColor(selectedEmissary),
                inactiveTrackColor = MaterialTheme.colorScheme.surface,
                inactiveTickColor = MaterialTheme.colorScheme.inverseSurface,
                activeTickColor = MaterialTheme.colorScheme.inverseSurface,
            ),
            modifier = Modifier
                .clip(shape = RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp))
                .background(color = MaterialTheme.colorScheme.surfaceDim,)
                .padding(horizontal = MaterialTheme.spacing.medium)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun EmissarySelectorPreview() {
    SotTreasureTrackerTheme {
        EmissarySelector(
            selectedEmissary = Emissary.GOLD_HOARDERS,
            emissaryGrade = EmissaryGrade.SECOND_GRADE,
            setSelectedEmissary = { },
            setEmissaryGrade = { },
        )
    }
}

@Composable
private fun trackColor(selectedEmissary: Emissary) = when (selectedEmissary) {
    Emissary.GOLD_HOARDERS -> Color(0xFFF4EB3C)
    Emissary.MERCHANT_ALLIANCE -> Color(0xFF1394B2)
    Emissary.ORDER_OF_SOULS -> Color(0xFFB44C84)
    Emissary.ATHENAS_FORTUNE -> Color(0xFF6CECAB)
    Emissary.REAPERS_BONES -> Color(0xFFB42414)
    Emissary.GUILD -> MaterialTheme.colorScheme.secondary
    Emissary.UNSELECTED -> MaterialTheme.colorScheme.secondary
}