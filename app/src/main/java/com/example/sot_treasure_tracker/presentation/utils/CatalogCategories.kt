package com.example.sot_treasure_tracker.presentation.utils

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
import com.example.compose.SotTreasureTrackerTheme
import com.example.sot_treasure_tracker.data.treasure.TreasureCatalogInstance
import com.example.sot_treasure_tracker.domain.models.Price
import com.example.sot_treasure_tracker.domain.models.CatalogCategory
import com.example.sot_treasure_tracker.domain.models.TreasureItem
import com.example.sot_treasure_tracker.domain.models.CategoryItem
import com.example.sot_treasure_tracker.presentation.utils.theme.fontSize
import com.example.sot_treasure_tracker.presentation.utils.theme.spacing
import com.example.sot_treasure_tracker.data.presets.PresetsCatalogInstance
import com.example.sot_treasure_tracker.domain.models.PresetItem
import com.example.sot_treasure_tracker.domain.models.PresetReward
import com.example.sot_treasure_tracker.presentation.presets.models.CostValues

@Composable
fun CatalogCategories(
    modifier: Modifier = Modifier,
    categories: List<CatalogCategory>,
    setItemQuantity: (CategoryItem, Int) -> Unit,
    calculateValues: (List<PresetReward>) -> CostValues = {
        CostValues(0, 0, 0)
    }
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
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
                when (item) {
                    is TreasureItem -> {
                        CategoryItem(
                            item = item,
                            minGoldAmount = (item.price as? Price.GoldRange)?.gold?.first ?: 0,
                            maxGoldAmount = (item.price as? Price.GoldRange)?.gold?.last ?: 0,
                            doubloonsAmount = (item.price as? Price.Doubloons)?.doubloons ?: 0,
                            emissaryValueAmount = item.emissaryValue,
                            setItemQuantity = setItemQuantity
                        )
                    }

                    is PresetItem -> {
                        CategoryItem(
                            item = item,
                            minGoldAmount = calculateValues.invoke(item.items).minGoldAmount,
                            maxGoldAmount = calculateValues.invoke(item.items).maxGoldAmount,
                            doubloonsAmount = calculateValues.invoke(item.items).doubloonsAmount,
                            emissaryValueAmount = 0,
                            setItemQuantity = setItemQuantity
                        )
                    }
                }

                Spacer(modifier = Modifier.height(MaterialTheme.spacing.small))
            }
        }
    }
}


@Composable
private fun CategoryItem(
    item: CategoryItem,
    minGoldAmount: Int,
    maxGoldAmount: Int,
    doubloonsAmount: Int,
    emissaryValueAmount:Int,
    setItemQuantity: (CategoryItem, Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = MaterialTheme.spacing.medium)
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

                CostValues(
                    minGoldAmount = minGoldAmount,
                    maxGoldAmount = maxGoldAmount,
                    doubloonsAmount = doubloonsAmount,
                    emissaryValueAmount = emissaryValueAmount
                )


            }

            Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

            TreasureItemCounter(
                categoryItem = item,
                setTreasureItemQuantity = setItemQuantity
            )
        }
    }
}

@Composable
private fun TreasureItemCounter(
    categoryItem: CategoryItem,
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
            onClick = { setTreasureItemQuantity(categoryItem, categoryItem.quantity + 1) }
        ) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }

        Text(
            text = categoryItem.quantity.toString(),
            fontSize = MaterialTheme.fontSize.heading,
            fontWeight = FontWeight.Bold,)

        IconButton(
            onClick = { setTreasureItemQuantity(categoryItem, categoryItem.quantity - 1) },
            enabled = categoryItem.quantity > 0
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
    SotTreasureTrackerTheme {
        CatalogCategories(
            categories = presetCatalog,
            setItemQuantity = { _, _ -> }
        )
    }
}