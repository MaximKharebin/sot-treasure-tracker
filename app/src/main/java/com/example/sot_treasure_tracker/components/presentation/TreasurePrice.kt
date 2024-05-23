package com.example.sot_treasure_tracker.components.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem
import com.example.sot_treasure_tracker.components.presentation.theme.fontSize
import com.example.sot_treasure_tracker.components.presentation.theme.spacing

@Composable
fun TreasurePrice(
    price: Price,
    modifier: Modifier = Modifier
) {
    var priceString = ""
    var priceCurrency = 0

    when (price) {
        is Price.Doubloons -> {
            val treasurePrice = price.doubloons
            priceString = treasurePrice.toString()
            priceCurrency = R.drawable.img_currency_doubloons
        }

        is Price.GoldRange -> {
            val treasurePrice = price.gold
            priceString = "${treasurePrice.first}–${treasurePrice.last}"
            priceCurrency = R.drawable.img_currency_gold
        }
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = priceCurrency),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .padding(end = MaterialTheme.spacing.extraSmall)
        )
        Text(
            text = priceString,
            fontSize = MaterialTheme.fontSize.body,
            fontWeight = FontWeight.Normal
        )
    }
}