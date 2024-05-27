package com.example.sot_treasure_tracker.presentation.calculator

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material.icons.outlined.RestartAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sot_treasure_tracker.presentation.utils.theme.spacing

@Composable
fun ControlButtons(
    modifier: Modifier = Modifier,
    clearCalculator: () -> Unit,
    navigateToPresets: () -> Unit
) {
    Row(
        modifier = modifier
    ) {
        IconButton(
            onClick = { clearCalculator.invoke() }
        ) {
            Icon(
                imageVector = Icons.Outlined.RestartAlt,
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.width(MaterialTheme.spacing.extraSmall))

        IconButton(
            onClick = { navigateToPresets.invoke() }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                contentDescription = null
            )
        }
    }
}