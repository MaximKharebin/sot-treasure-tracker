package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.presentation.theme.spacing

@Composable
fun EmissaryIcon(
    drawableId: Int,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = contentDescription,
        modifier = modifier
            .background(color = MaterialTheme.colorScheme.inverseSurface)
            .padding(all = MaterialTheme.spacing.small)
    )
}

@Preview(showBackground = true)
@Composable
private fun EmissaryIconPreview() {
    EmissaryIcon(
        drawableId = R.drawable.logo_gh,
        contentDescription = stringResource(id = R.string.gold_hoarders),
        modifier = Modifier
            .clip(shape = RoundedCornerShape(50.dp))
            .size(48.dp)
    )
}