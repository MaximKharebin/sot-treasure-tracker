package com.example.sot_treasure_tracker.components.data.catalog_instance

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.data.models.TreasureCategoryDto
import com.example.sot_treasure_tracker.components.data.models.TreasureItemDto
import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.models.SellBuckets

object CatalogReapersBones {
    val treasure: List<TreasureCategoryDto> = listOf(
        TreasureCategoryDto(
            titleId = R.string.title_reapers_boxes,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.reapers_bounty,
                    price = Price.GoldRange(
                        10000..10000
                    ),
                    emissaryValue = 10800,
                    belongsTo = SellBuckets.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.reapers_chest,
                    price = Price.Doubloons(25),
                    emissaryValue = 10800,
                    belongsTo = SellBuckets.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.generous_gift,
                    price = Price.Doubloons(10),
                    emissaryValue = 2160,
                    belongsTo = SellBuckets.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.humble_gift,
                    price = Price.Doubloons(5),
                    emissaryValue = 1080,
                    belongsTo = SellBuckets.REAPERS_BONES
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_broken_emissary_flags,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.broken_emissary_flag_grade_5,
                    price = Price.GoldRange(9500..10500),
                    emissaryValue = 30000,
                    belongsTo = SellBuckets.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.broken_emissary_flag_grade_4,
                    price = Price.GoldRange(7600..8500),
                    emissaryValue = 24000,
                    belongsTo = SellBuckets.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.broken_emissary_flag_grade_3,
                    price = Price.GoldRange(5500..6500),
                    emissaryValue = 18000,
                    belongsTo = SellBuckets.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.broken_emissary_flag_grade_2,
                    price = Price.GoldRange(3500..4900),
                    emissaryValue = 12000,
                    belongsTo = SellBuckets.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.broken_emissary_flag_grade_1,
                    price = Price.GoldRange(1600..2400),
                    emissaryValue = 6000,
                    belongsTo = SellBuckets.REAPERS_BONES
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_captains_logbook,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.extraordinary_captains_logbook,
                    price = Price.GoldRange(
                        25000..25000
                    ),
                    emissaryValue = 0,
                    belongsTo = SellBuckets.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.remarkable_captains_logbook,
                    price = Price.GoldRange(
                        10000..10000
                    ),
                    emissaryValue = 0,
                    belongsTo = SellBuckets.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.accomplished_captains_logbook,
                    price = Price.GoldRange(2500..2500),
                    emissaryValue = 0,
                    belongsTo = SellBuckets.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.noteworthy_captains_logbook,
                    price = Price.GoldRange(300..300),
                    emissaryValue = 0,
                    belongsTo = SellBuckets.REAPERS_BONES
                )
            )
        )
    )
}
