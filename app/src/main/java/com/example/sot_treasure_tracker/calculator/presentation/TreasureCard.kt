package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem
import com.example.sot_treasure_tracker.components.presentation.TreasureItemCounter
import com.example.sot_treasure_tracker.components.presentation.TreasurePrice
import com.example.sot_treasure_tracker.components.presentation.theme.fontSize
import com.example.sot_treasure_tracker.components.presentation.theme.spacing

@Composable
fun TreasureItemTreasure(
    treasureItem: TreasureItem,
    setTreasureItemQuantity: (TreasureItem, Int) -> Unit
) {
    Card(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(all = MaterialTheme.spacing.small)
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(id = treasureItem.nameId),
                    fontSize = MaterialTheme.fontSize.heading,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Emissary value: ${treasureItem.emissaryValue}",
                    fontSize = MaterialTheme.fontSize.body,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(vertical = MaterialTheme.spacing.extraSmall)
                )
                TreasurePrice(price = treasureItem.price)
            }

            TreasureItemCounter(
                treasureItem = treasureItem,
                setTreasureItemQuantity = setTreasureItemQuantity
            )
        }
    }
}