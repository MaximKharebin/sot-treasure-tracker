package com.example.sot_treasure_tracker.data.catalog

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.models.Treasure
import com.example.sot_treasure_tracker.components.SellFractions
import com.example.sot_treasure_tracker.components.Price
import com.example.sot_treasure_tracker.data.models.TreasureItem
import com.example.sot_treasure_tracker.data.models.TreasureCategory

object ReapersBones : Treasure {
    override val treasure: List<TreasureCategory> = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_reapers_boxes,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.reapers_bounty,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 10800,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.reapers_chest,
                    price = Price.Doubloons(25),
                    emissaryValue = 10800,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.generous_gift,
                    price = Price.Doubloons(10),
                    emissaryValue = 2160,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.humble_gift,
                    price = Price.Doubloons(5),
                    emissaryValue = 1080,
                    canSellTo = SellFractions.REAPERS_BONES
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_broken_emissary_flags,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.broken_emissary_flag_grade_5,
                    price = Price.Gold(9500..10500),
                    emissaryValue = 30000,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.broken_emissary_flag_grade_4,
                    price = Price.Gold(7600..8500),
                    emissaryValue = 24000,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.broken_emissary_flag_grade_3,
                    price = Price.Gold(5500..6500),
                    emissaryValue = 18000,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.broken_emissary_flag_grade_2,
                    price = Price.Gold(3500..4900),
                    emissaryValue = 12000,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.broken_emissary_flag_grade_1,
                    price = Price.Gold(1600..2400),
                    emissaryValue = 6000,
                    canSellTo = SellFractions.REAPERS_BONES
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_captains_logbook,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.extraordinary_captains_logbook,
                    price = Price.Gold(25000..25000),
                    emissaryValue = 0,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.remarkable_captains_logbook,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 0,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.accomplished_captains_logbook,
                    price = Price.Gold(2500..2500),
                    emissaryValue = 0,
                    canSellTo = SellFractions.REAPERS_BONES
                ),
                TreasureItem(
                    name = R.string.noteworthy_captains_logbook,
                    price = Price.Gold(300..300),
                    emissaryValue = 0,
                    canSellTo = SellFractions.REAPERS_BONES
                )
            )
        )
    )
}
