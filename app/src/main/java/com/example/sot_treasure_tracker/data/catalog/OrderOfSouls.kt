package com.example.sot_treasure_tracker.data.catalog

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.Price
import com.example.sot_treasure_tracker.data.models.TreasureCategory
import com.example.sot_treasure_tracker.data.models.Treasure
import com.example.sot_treasure_tracker.components.Fraction
import com.example.sot_treasure_tracker.data.models.TreasureItem

object OrderOfSouls : Treasure {
    override val treasure: List<TreasureCategory> = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_regular_skulls,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.skull_villainous_bounty_skull,
                    price = Price.Gold(750..1450),
                    emissaryValue = 3240,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_hateful_bounty_skull,
                    price = Price.Gold(350..750),
                    emissaryValue = 1620,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_disgraced_bounty_skull,
                    price = Price.Gold(180..350),
                    emissaryValue = 810,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_foul_bounty_skull,
                    price = Price.Gold(90..180),
                    emissaryValue = 405,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_ashen_skulls,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.skull_ashen_villainous_bounty_skull,
                    price = Price.Gold(1450..2800),
                    emissaryValue = 6480,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_ashen_hateful_bounty_skull,
                    price = Price.Gold(750..1450),
                    emissaryValue = 3240,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_ashen_disgraced_bounty_skull,
                    price = Price.Gold(350..750),
                    emissaryValue = 1620,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_ashen_foul_bounty_skull,
                    price = Price.Gold(180..350),
                    emissaryValue = 810,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_coral_skulls,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.skull_coral_villainous_bounty_skull,
                    price = Price.Gold(1300..2550),
                    emissaryValue = 5670,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_coral_hateful_bounty_skull,
                    price = Price.Gold(600..1350),
                    emissaryValue = 2835,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_coral_disgraced_bounty_skull,
                    price = Price.Gold(300..650),
                    emissaryValue = 1419,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_coral_foul_bounty_skull,
                    price = Price.Gold(150..315),
                    emissaryValue = 711,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_powerful_skulls,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.skull_ashen_winds_skull,
                    price = Price.Gold(4000..10000),
                    emissaryValue = 15750,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_stronghold_skull,
                    price = Price.Gold(0..0),
                    emissaryValue = 9720,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_skeleton_captains_skull,
                    price = Price.Gold(850..2200),
                    emissaryValue = 4860,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_ghostly_skulls,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.skull_captain_skull_of_the_damned,
                    price = Price.Gold(1700..2950),
                    emissaryValue = 7290,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.skull_skull_of_the_damned,
                    price = Price.Gold(1050..1250),
                    emissaryValue = 3480,
                    canSellTo = Fraction.ORDER_OF_SOULS
                ),
            )
        ),
    )
}
