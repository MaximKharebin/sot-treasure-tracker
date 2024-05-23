package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.R

@Composable
fun CostValues(
    minGoldAmount: Int,
    maxGoldAmount: Int,
    doubloonsAmount: Int,
    emissaryValueAmount: Int,
) {
    Row {
        Row {
            Image(
                painter = painterResource(id = R.drawable.img_currency_gold),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(text = "$minGoldAmount–$maxGoldAmount")
        }
        Row {
            Image(
                painter = painterResource(id = R.drawable.img_currency_doubloons),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(text = "$doubloonsAmount")
        }
    }
    Row {
        Text(text = "Emissary value: $emissaryValueAmount")
    }
}