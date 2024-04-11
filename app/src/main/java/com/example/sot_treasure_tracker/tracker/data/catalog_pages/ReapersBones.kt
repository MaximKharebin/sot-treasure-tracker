package com.example.sot_treasure_tracker.calculator.data.catalog_pages

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.data.models.TreasureCategoryDto
import com.example.sot_treasure_tracker.calculator.data.models.TreasureItemDto
import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.models.SellFractions
import com.example.sot_treasure_tracker.calculator.domain.models.TreasurePage

object ReapersBones : TreasurePage {
    override val page: List<TreasureCategoryDto> = listOf(
        TreasureCategoryDto(
            titleId = R.string.title_reapers_boxes,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.reapers_bounty,
                    price = Price.GoldRange(
                        10000..10000
                    ),
                    emissaryValue = 10800,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.reapers_chest,
                    price = Price.Doubloons(25),
                    emissaryValue = 10800,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.generous_gift,
                    price = Price.Doubloons(10),
                    emissaryValue = 2160,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.humble_gift,
                    price = Price.Doubloons(5),
                    emissaryValue = 1080,
                    belongsTo = SellFractions.REAPERS_BONES
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_broken_emissary_flags,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.broken_emissary_flag_grade_5,
                    price = Price.GoldRange(9500..10500),
                    emissaryValue = 30000,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.broken_emissary_flag_grade_4,
                    price = Price.GoldRange(7600..8500),
                    emissaryValue = 24000,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.broken_emissary_flag_grade_3,
                    price = Price.GoldRange(5500..6500),
                    emissaryValue = 18000,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.broken_emissary_flag_grade_2,
                    price = Price.GoldRange(3500..4900),
                    emissaryValue = 12000,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.broken_emissary_flag_grade_1,
                    price = Price.GoldRange(1600..2400),
                    emissaryValue = 6000,
                    belongsTo = SellFractions.REAPERS_BONES
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_captains_logbook,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.extraordinary_captains_logbook,
                    price = Price.GoldRange(
                        25000..25000
                    ),
                    emissaryValue = 0,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.remarkable_captains_logbook,
                    price = Price.GoldRange(
                        10000..10000
                    ),
                    emissaryValue = 0,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.accomplished_captains_logbook,
                    price = Price.GoldRange(2500..2500),
                    emissaryValue = 0,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.noteworthy_captains_logbook,
                    price = Price.GoldRange(300..300),
                    emissaryValue = 0,
                    belongsTo = SellFractions.REAPERS_BONES
                )
            )
        )
    )
}
