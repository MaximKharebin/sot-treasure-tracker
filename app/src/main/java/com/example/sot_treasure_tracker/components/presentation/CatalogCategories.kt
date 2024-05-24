package com.example.sot_treasure_tracker.components.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sot_treasure_tracker.calculator.data.TreasureCatalogInstance
import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.components.domain.models.CatalogCategory
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem
import com.example.sot_treasure_tracker.components.domain.models.CategoryItem
import com.example.sot_treasure_tracker.components.presentation.theme.fontSize
import com.example.sot_treasure_tracker.components.presentation.theme.spacing
import com.example.sot_treasure_tracker.presets.data.PresetsCatalogInstance

@Composable
fun CatalogCategories(
    categories: List<CatalogCategory>,
    setItemQuantity: (CategoryItem, Int) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(categories) { category ->

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

            Text(
                text = stringResource(id = category.titleId),
                fontSize = MaterialTheme.fontSize.heading,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium)
            )

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

            category.items.forEach { item ->
                CategoryItem(
                    item = item,
                    setItemQuantity = setItemQuantity
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            }
        }
    }
}


@Composable
private fun CategoryItem(
    item: CategoryItem,
    setItemQuantity: (CategoryItem, Int) -> Unit
) {
    Card(
        modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium)
    ) {
        Row(modifier = Modifier.padding(all = MaterialTheme.spacing.small)) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = stringResource(id = item.titleId),
                    fontSize = MaterialTheme.fontSize.heading,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))

                val itemAsTreasureItem = (item as? TreasureItem)

                CostValues(
                    minGoldAmount = (itemAsTreasureItem?.price as? Price.GoldRange)?.gold?.first ?: 0,
                    maxGoldAmount = (itemAsTreasureItem?.price as? Price.GoldRange)?.gold?.last ?: 0,
                    doubloonsAmount = (itemAsTreasureItem?.price as? Price.Doubloons)?.doubloons ?: 0,
                    emissaryValueAmount = itemAsTreasureItem?.emissaryValue ?: 0
                )
            }

            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

            TreasureItemCounter(
                treasureItem = item,
                setTreasureItemQuantity = setItemQuantity
            )
        }
    }
}

@Composable
private fun TreasureItemCounter(
    treasureItem: CategoryItem,
    setTreasureItemQuantity: (CategoryItem, Int) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(8.dp)
            )
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

@Preview(showBackground = true)
@Composable
private fun CatalogCategoriesPreview() {

    val treasureCatalog = TreasureCatalogInstance.catalog[0]
    val presetCatalog = PresetsCatalogInstance.catalog

    CatalogCategories(
        categories = presetCatalog,
        setItemQuantity = { _, _ -> }
    )
}