package com.example.sot_treasure_tracker.components.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.sot_treasure_tracker.calculator.data.TreasureCatalogInstance
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureCategory
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem
import com.example.sot_treasure_tracker.calculator.presentation.TreasureItemTreasure
import com.example.sot_treasure_tracker.components.presentation.theme.fontSize
import com.example.sot_treasure_tracker.components.presentation.theme.spacing

@Composable
fun ListOfCategories(
    treasureCategories: List<TreasureCategory>,
    setTreasureItemQuantity: (TreasureItem, Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(treasureCategories) { treasureCategory ->

            Text(
                text = stringResource(id = treasureCategory.titleId),
                fontSize = MaterialTheme.fontSize.heading,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = MaterialTheme.spacing.medium)
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

@Preview(showBackground = true)
@Composable
fun TreasureCategoryListPreview() {
    ListOfCategories(
        treasureCategories = TreasureCatalogInstance.catalog[0],
        setTreasureItemQuantity = { _, _ -> }
    )
}