package com.example.sot_treasure_tracker.data.catalog

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.Price
import com.example.sot_treasure_tracker.data.models.TreasureCategory
import com.example.sot_treasure_tracker.data.models.Treasure
import com.example.sot_treasure_tracker.components.SellFractions
import com.example.sot_treasure_tracker.data.models.TreasureItem

object OrderOfSouls : Treasure {
    override val treasure: List<TreasureCategory> = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_regular_skulls,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.oos_wrathful_kings_bounty_skull,
                    price = Price.Gold(5100..5200),
                    emissaryValue = 15450,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_vicious_bounty_skull,
                    price = Price.Gold(3600..3650),
                    emissaryValue = 10875,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_corrupted_bounty_skull,
                    price = Price.Gold(2440..2460),
                    emissaryValue = 7350,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_vile_bounty_skull,
                    price = Price.Gold(1500..1550),
                    emissaryValue = 4575,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_dark_bounty_skull,
                    price = Price.Gold(1000..1050),
                    emissaryValue = 3075,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_villainous_bounty_skull,
                    price = Price.Gold(750..1450),
                    emissaryValue = 3240,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_hateful_bounty_skull,
                    price = Price.Gold(350..750),
                    emissaryValue = 1620,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_disgraced_bounty_skull,
                    price = Price.Gold(180..350),
                    emissaryValue = 810,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_foul_bounty_skull,
                    price = Price.Gold(90..180),
                    emissaryValue = 405,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_ashen_skulls,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.oos_ashen_wrathful_kings_bounty_skull,
                    price = Price.Gold(5800..5900),
                    emissaryValue = 17550,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_ashen_vicious_bounty_skull,
                    price = Price.Gold(4800..4850),
                    emissaryValue = 14475,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_ashen_corrupted_bounty_skull,
                    price = Price.Gold(3210..3230),
                    emissaryValue = 9660,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_ashen_vile_bounty_skull,
                    price = Price.Gold(1850..1900),
                    emissaryValue = 5625,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_ashen_dark_bounty_skull,
                    price = Price.Gold(1250..1260),
                    emissaryValue = 3750,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_ashen_villainous_bounty_skull,
                    price = Price.Gold(1450..2800),
                    emissaryValue = 6480,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_ashen_hateful_bounty_skull,
                    price = Price.Gold(750..1450),
                    emissaryValue = 3240,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_ashen_disgraced_bounty_skull,
                    price = Price.Gold(350..750),
                    emissaryValue = 1620,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_ashen_foul_bounty_skull,
                    price = Price.Gold(180..350),
                    emissaryValue = 810,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_coral_skulls,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.oos_coral_villainous_bounty_skull,
                    price = Price.Gold(1310..2540),
                    emissaryValue = 5670,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_coral_hateful_bounty_skull,
                    price = Price.Gold(610..1310),
                    emissaryValue = 2835,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_coral_disgraced_bounty_skull,
                    price = Price.Gold(315..615),
                    emissaryValue = 1419,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_coral_foul_bounty_skull,
                    price = Price.Gold(155..315),
                    emissaryValue = 711,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_encounter_and_quest_skulls,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.oos_ashen_winds_skull,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 15750,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_gold_hoarders_skull,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 0,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_stronghold_skull,
                    price = Price.Gold(1800..4200),
                    emissaryValue = 9720,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_captain_skull_of_the_damned,
                    price = Price.Gold(1700..2950),
                    emissaryValue = 7290,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_skull_of_the_damned,
                    price = Price.Gold(1050..1250),
                    emissaryValue = 3480,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_skeleton_captains_skull,
                    price = Price.Gold(850..2200),
                    emissaryValue = 4860,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_dark_relics,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.oos_hexing_skull,
                    price = Price.Gold(0..0),
                    emissaryValue = 0,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_enchantment_vessel,
                    price = Price.Gold(0..0),
                    emissaryValue = 0,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_evil_eye,
                    price = Price.Gold(0..0),
                    emissaryValue = 0,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_mutinous_effigy,
                    price = Price.Gold(0..0),
                    emissaryValue = 0,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_bewitching_doll,
                    price = Price.Gold(0..0),
                    emissaryValue = 0,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_raid_treasures,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.oos_all_seeing_eye_of_souls,
                    price = Price.Gold(15000..15000),
                    emissaryValue = 45000,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_veiled_eye_of_souls,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 30000,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItem(
                    name = R.string.oos_eye_of_souls,
                    price = Price.Gold(5000..5000),
                    emissaryValue = 15000,
                    canSellTo = SellFractions.ORDER_OF_SOULS
                )
            )
        )
    )
}
