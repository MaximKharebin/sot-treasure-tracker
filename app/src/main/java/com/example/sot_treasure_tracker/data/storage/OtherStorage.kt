package com.example.sot_treasure_tracker.data.storage

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.model.Price
import com.example.sot_treasure_tracker.data.model.TreasureCategory
import com.example.sot_treasure_tracker.data.TreasureList
import com.example.sot_treasure_tracker.model.Fraction
import com.example.sot_treasure_tracker.data.model.Treasure

object OtherStorage : TreasureList {
    override val treasure = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_shared_treasure,
            categoryItems = listOf(
                Treasure(
                    name = R.string.sapphire_gems,
                    price = Price.Gold(1000..1000),
                    emissaryValue = 3000,
                    canSellTo = listOf(
                        Fraction.GOLD_HOARDERS,
                        Fraction.MERCHANT_ALLIANCE,
                        Fraction.ORDER_OF_SOULS,
                        Fraction.REAPERS_BONES,
                        Fraction.OTHER
                    )
                ),
                Treasure(
                    name = R.string.emerald_gems,
                    price = Price.Gold(1500..1500),
                    emissaryValue = 4500,
                    canSellTo = listOf(
                        Fraction.GOLD_HOARDERS,
                        Fraction.MERCHANT_ALLIANCE,
                        Fraction.ORDER_OF_SOULS,
                        Fraction.REAPERS_BONES,
                        Fraction.OTHER
                    )
                ),
                Treasure(
                    name = R.string.ruby_gems,
                    price = Price.Gold(2000..2000),
                    emissaryValue = 6000,
                    canSellTo = listOf(
                        Fraction.GOLD_HOARDERS,
                        Fraction.MERCHANT_ALLIANCE,
                        Fraction.ORDER_OF_SOULS,
                        Fraction.REAPERS_BONES,
                        Fraction.OTHER
                    )
                ),
                Treasure(
                    name = R.string.treasure_chest,
                    price = Price.Gold(250..520),
                    emissaryValue = 0,
                    canSellTo = listOf(
                        Fraction.GOLD_HOARDERS,
                        Fraction.MERCHANT_ALLIANCE,
                        Fraction.ORDER_OF_SOULS,
                        Fraction.REAPERS_BONES,
                        Fraction.OTHER
                    )
                ),
                Treasure(
                    name = R.string.coral_treasure_chest,
                    price = Price.Gold(375..780),
                    emissaryValue = 0,
                    canSellTo = listOf(
                        Fraction.GOLD_HOARDERS,
                        Fraction.MERCHANT_ALLIANCE,
                        Fraction.ORDER_OF_SOULS,
                        Fraction.REAPERS_BONES,
                        Fraction.OTHER
                    )
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_standalone_treasure,
            categoryItems = listOf(
                Treasure(
                    name = R.string.box_of_wondrous_secrets,
                    price = Price.Gold(25000..25000),
                    emissaryValue = 0,
                    canSellTo = listOf(Fraction.OTHER)
                ),
            )
        ),
    )
}
