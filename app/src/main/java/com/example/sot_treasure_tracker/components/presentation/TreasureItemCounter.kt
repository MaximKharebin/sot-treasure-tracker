package com.example.sot_treasure_tracker.components.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem
import com.example.sot_treasure_tracker.components.presentation.theme.fontSize

@Composable
fun TreasureItemCounter(
    treasureItem: TreasureItem,
    setTreasureItemQuantity: (TreasureItem, Int) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(20.dp))
    ) {

        IconButton(
            onClick = { setTreasureItemQuantity(treasureItem, treasureItem.quantity + 1) }
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }

        Text(
            text = treasureItem.quantity.toString(),
            fontSize = MaterialTheme.fontSize.heading,
            fontWeight = FontWeight.Bold,)

        IconButton(
            onClick = { setTreasureItemQuantity(treasureItem, treasureItem.quantity - 1) },
            enabled = treasureItem.quantity > 0
        ) {
            Icon(imageVector = Icons.Filled.Remove, contentDescription = null)
        }
    }
}