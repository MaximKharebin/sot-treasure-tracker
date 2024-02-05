package com.example.sot_treasure_tracker.data.storage

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.TreasureList
import com.example.sot_treasure_tracker.model.Fraction
import com.example.sot_treasure_tracker.data.model.Price
import com.example.sot_treasure_tracker.data.model.Treasure
import com.example.sot_treasure_tracker.data.model.TreasureCategory

object ReapersBonesStorage : TreasureList {
    override val treasure = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_reapers_treasure,
            categoryItems = listOf(
                Treasure(
                    name = R.string.reapers_bounty,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 10800,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.reapers_chest,
                    price = Price.Doubloons(25),
                    emissaryValue = 10800,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.humble_gift,
                    price = Price.Doubloons(5),
                    emissaryValue = 1080,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.generous_gift,
                    price = Price.Doubloons(10),
                    emissaryValue = 2160,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_broken_emissary_flags,
            categoryItems = listOf(
                Treasure(
                    name = R.string.broken_emissary_flag_grade_1,
                    price = Price.Gold(1600..2400),
                    emissaryValue = 6000,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.broken_emissary_flag_grade_2,
                    price = Price.Gold(3500..4900),
                    emissaryValue = 12000,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.broken_emissary_flag_grade_3,
                    price = Price.Gold(5500..6500),
                    emissaryValue = 18000,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.broken_emissary_flag_grade_4,
                    price = Price.Gold(7600..8500),
                    emissaryValue = 24000,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.broken_emissary_flag_grade_5,
                    price = Price.Gold(9500..10500),
                    emissaryValue = 30000,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_captains_logbook,
            categoryItems = listOf(
                Treasure(
                    name = R.string.noteworthy_captains_logbook,
                    price = Price.Gold(300..300),
                    emissaryValue = 0,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.accomplished_captains_logbook,
                    price = Price.Gold(2500..2500),
                    emissaryValue = 0,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.remarkable_captains_logbook,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 0,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.extraordinary_captains_logbook,
                    price = Price.Gold(25000..25000),
                    emissaryValue = 0,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_bilge_rats,
            categoryItems = listOf(
                Treasure(
                    name = R.string.ashen_tomes,
                    price = Price.Doubloons(10),
                    emissaryValue = 1080,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.ashen_chest,
                    price = Price.Doubloons(5),
                    emissaryValue = 540,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.ashen_key,
                    price = Price.Doubloons(5),
                    emissaryValue = 900,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.ritual_skull,
                    price = Price.Doubloons(10),
                    emissaryValue = 750,
                    canSellTo = listOf(Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.rag_and_bone_crates,
                    price = Price.Doubloons(5),
                    emissaryValue = 1080,
                    canSellTo = listOf(Fraction.MERCHANT_ALLIANCE)
                ),
            )
        ),
    )
}
