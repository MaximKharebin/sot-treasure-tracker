package com.example.sot_treasure_tracker.calculator.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.data.catalog_instance.TreasureCatalogInstance
import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureCategory
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem

@Composable
fun TreasureCategoryList(
    treasureCategories: List<TreasureCategory>,
    setTreasureItemQuantity: (TreasureItem, Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
    ) {
        items(treasureCategories) { treasureCategory ->

            Text(
                text = stringResource(id = treasureCategory.titleId),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            treasureCategory.items.forEach { treasureItem ->
                TreasureItemTreasure(
                    treasureItem = treasureItem,
                    setTreasureItemQuantity = { item, newQuantity ->
                        setTreasureItemQuantity(item, newQuantity)
                    }
                )
            }
        }
    }
}

@Composable
fun TreasureItemTreasure(
    treasureItem: TreasureItem,
    setTreasureItemQuantity: (TreasureItem, Int) -> Unit
) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = treasureItem.nameId))
            Text(text = "Emissary value: ${treasureItem.emissaryValue}")
            when (treasureItem.price) {
                is Price.Doubloons -> {
                    val price = (treasureItem.price as Price.Doubloons).doubloons
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.img_currency_doubloons),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = stringResource(
                                id = R.string.treasure_price_single,
                                formatArgs = arrayOf(price)
                            )
                        )
                    }
                }

                is Price.GoldRange -> {
                    val price = (treasureItem.price as Price.GoldRange).gold
                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.img_currency_gold),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Text(
                            text = stringResource(
                                id = R.string.treasure_price_range,
                                formatArgs = arrayOf(price.first, price.last)
                            )
                        )
                    }
                }
            }


        }

        TreasureItemCounter(
            treasureItem = treasureItem,
            setTreasureItemQuantity = setTreasureItemQuantity
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TreasureCategoryListPreview() {
    TreasureCategoryList(
        treasureCategories = TreasureCatalogInstance.catalog[0],
        setTreasureItemQuantity = { _, _ -> }
    )
}