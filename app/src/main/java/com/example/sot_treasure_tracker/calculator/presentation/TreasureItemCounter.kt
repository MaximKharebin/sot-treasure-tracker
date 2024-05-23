package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem

@Composable
fun TreasureItemCounter(
    treasureItem: TreasureItem,
    setTreasureItemQuantity: (TreasureItem, Int) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { setTreasureItemQuantity(treasureItem, treasureItem.quantity + 1) }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }

        Text(text = treasureItem.quantity.toString())

        Button(onClick = { setTreasureItemQuantity(treasureItem, treasureItem.quantity - 1) }) {
            Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
        }
    }
}