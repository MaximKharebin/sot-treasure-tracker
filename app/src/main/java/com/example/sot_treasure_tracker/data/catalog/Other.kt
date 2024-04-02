package com.example.sot_treasure_tracker.data.catalog

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.Price
import com.example.sot_treasure_tracker.data.models.TreasureCategory
import com.example.sot_treasure_tracker.data.models.Treasure
import com.example.sot_treasure_tracker.components.Fraction
import com.example.sot_treasure_tracker.data.models.TreasureItem

object Other : Treasure {
    override val treasure: List<TreasureCategory> = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_shared_treasure,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.sapphire_gems,
                    price = Price.Gold(1000..1000),
                    emissaryValue = 3000,
                    canSellTo = Fraction.SHARED
                ),
                TreasureItem(
                    name = R.string.emerald_gems,
                    price = Price.Gold(1500..1500),
                    emissaryValue = 4500,
                    canSellTo = Fraction.SHARED
                ),
                TreasureItem(
                    name = R.string.ruby_gems,
                    price = Price.Gold(2000..2000),
                    emissaryValue = 6000,
                    canSellTo = Fraction.SHARED
                ),
                TreasureItem(
                    name = R.string.treasure_chest,
                    price = Price.Gold(250..520),
                    emissaryValue = 0,
                    canSellTo = Fraction.SHARED
                ),
                TreasureItem(
                    name = R.string.coral_treasure_chest,
                    price = Price.Gold(375..780),
                    emissaryValue = 0,
                    canSellTo = Fraction.SHARED
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_standalone_treasure,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.box_of_wondrous_secrets,
                    price = Price.Gold(25000..25000),
                    emissaryValue = 0,
                    canSellTo = Fraction.UNIQUE
                )
            )
        )
    )
}
