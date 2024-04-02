package com.example.sot_treasure_tracker.data.catalog

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.Price
import com.example.sot_treasure_tracker.data.models.TreasureCategory
import com.example.sot_treasure_tracker.data.models.Treasure
import com.example.sot_treasure_tracker.components.SellFractions
import com.example.sot_treasure_tracker.data.models.TreasureItem

object Other : Treasure {
    override val treasure: List<TreasureCategory> = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_gem_stones,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ruby_gems,
                    price = Price.Gold(2000..2000),
                    emissaryValue = 6000,
                    canSellTo = SellFractions.SHARED
                ),
                TreasureItem(
                    name = R.string.emerald_gems,
                    price = Price.Gold(1500..1500),
                    emissaryValue = 4500,
                    canSellTo = SellFractions.SHARED
                ),
                TreasureItem(
                    name = R.string.sapphire_gems,
                    price = Price.Gold(1000..1000),
                    emissaryValue = 3000,
                    canSellTo = SellFractions.SHARED
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_treasure_chests,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.treasure_chest,
                    price = Price.Gold(250..520),
                    emissaryValue = 0,
                    canSellTo = SellFractions.SHARED
                ),
                TreasureItem(
                    name = R.string.coral_treasure_chest,
                    price = Price.Gold(375..780),
                    emissaryValue = 0,
                    canSellTo = SellFractions.SHARED
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_breath_of_the_sea,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ruby_breath_of_the_sea,
                    price = Price.Gold(8000..8000),
                    emissaryValue = 24000,
                    canSellTo = SellFractions.SHARED
                ),
                TreasureItem(
                    name = R.string.emerald_breath_of_the_sea,
                    price = Price.Gold(6000..6000),
                    emissaryValue = 18000,
                    canSellTo = SellFractions.SHARED
                ),
                TreasureItem(
                    name = R.string.sapphire_breath_of_the_sea,
                    price = Price.Gold(4000..4000),
                    emissaryValue = 12000,
                    canSellTo = SellFractions.SHARED
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_bilge_rats,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ashen_tomes,
                    price = Price.Doubloons(10),
                    emissaryValue = 1080,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.ashen_chest,
                    price = Price.Doubloons(5),
                    emissaryValue = 540,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.ashen_key,
                    price = Price.Doubloons(5),
                    emissaryValue = 900,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.ritual_skull,
                    price = Price.Doubloons(10),
                    emissaryValue = 750,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.rag_and_bone_crates,
                    price = Price.Doubloons(5),
                    emissaryValue = 1080,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_standalone_treasure,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.box_of_wondrous_secrets,
                    price = Price.Gold(25000..25000),
                    emissaryValue = 0,
                    canSellTo = SellFractions.UNIQUE
                ),
                TreasureItem(
                    name = R.string.skull_of_siren_song,
                    price = Price.Gold(50000..50000),
                    emissaryValue = 0,
                    canSellTo = SellFractions.UNIQUE
                )
            )
        )
    )
}
