package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.RemoveCircleOutline
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.components.presentation.theme.spacing

@Composable
fun ControlButtons(
    modifier: Modifier = Modifier,
    clearCalculator: () -> Unit,
    navigateToPresets: () -> Unit
) {
    Row {
        FilledIconButton(
            onClick = { clearCalculator.invoke() },
            modifier = Modifier
                .padding(start = MaterialTheme.spacing.medium)
                .background(
                    MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(50.dp)
                )
        ) {
            Icon(
                imageVector = Icons.Outlined.RemoveCircleOutline,
                contentDescription = null
            )
        }
        FilledIconButton(
            onClick = { navigateToPresets.invoke() },
            modifier = Modifier
                .padding(start = MaterialTheme.spacing.medium)
                .background(
                    MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(50.dp)
                )
        ) {
            Icon(
                imageVector = Icons.Outlined.ShoppingCart,
                contentDescription = null
            )
        }
    }
}