package com.example.sot_treasure_tracker.data.storage

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.Price
import com.example.sot_treasure_tracker.data.TreasureCategory
import com.example.sot_treasure_tracker.data.TreasureList
import com.example.sot_treasure_tracker.data.model.OrderOfSoulsTreasure

object OrderOfSoulsStorage : TreasureList<OrderOfSoulsTreasure> {
    override val treasure = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_regular_skulls,
            categoryItems = listOf(
                OrderOfSoulsTreasure(
                    name = R.string.skull_villainous_bounty_skull,
                    price = Price.Gold(750..1450),
                    emissaryValue = 3240,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_hateful_bounty_skull,
                    price = Price.Gold(350..750),
                    emissaryValue = 1620,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_disgraced_bounty_skull,
                    price = Price.Gold(180..350),
                    emissaryValue = 810,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_foul_bounty_skull,
                    price = Price.Gold(90..180),
                    emissaryValue = 405,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_ashen_skulls,
            categoryItems = listOf(
                OrderOfSoulsTreasure(
                    name = R.string.skull_ashen_villainous_bounty_skull,
                    price = Price.Gold(1450..2800),
                    emissaryValue = 6480,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_ashen_hateful_bounty_skull,
                    price = Price.Gold(750..1450),
                    emissaryValue = 3240,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_ashen_disgraced_bounty_skull,
                    price = Price.Gold(350..750),
                    emissaryValue = 1620,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_ashen_foul_bounty_skull,
                    price = Price.Gold(180..350),
                    emissaryValue = 810,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_coral_skulls,
            categoryItems = listOf(
                OrderOfSoulsTreasure(
                    name = R.string.skull_coral_villainous_bounty_skull,
                    price = Price.Gold(1300..2550),
                    emissaryValue = 5670,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_coral_hateful_bounty_skull,
                    price = Price.Gold(600..1350),
                    emissaryValue = 2835,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_coral_disgraced_bounty_skull,
                    price = Price.Gold(300..650),
                    emissaryValue = 1419,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_coral_foul_bounty_skull,
                    price = Price.Gold(150..315),
                    emissaryValue = 711,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_powerful_skulls,
            categoryItems = listOf(
                OrderOfSoulsTreasure(
                    name = R.string.skull_ashen_winds_skull,
                    price = Price.Gold(4000..10000),
                    emissaryValue = 15750,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_stronghold_skull,
                    price = Price.Gold(0..0),
                    emissaryValue = 9720,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_skeleton_captains_skull,
                    price = Price.Gold(850..2200),
                    emissaryValue = 4860,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_ghostly_skulls,
            categoryItems = listOf(
                OrderOfSoulsTreasure(
                    name = R.string.skull_captain_skull_of_the_damned,
                    price = Price.Gold(1700..2950),
                    emissaryValue = 7290,
                ),
                OrderOfSoulsTreasure(
                    name = R.string.skull_skull_of_the_damned,
                    price = Price.Gold(1050..1250),
                    emissaryValue = 3480,
                ),
            )
        ),
    )
}
