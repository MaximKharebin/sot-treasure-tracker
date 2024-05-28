package com.example.sot_treasure_tracker.data.treasure.catalog_instance

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.treasure.models.TreasureCategoryDto
import com.example.sot_treasure_tracker.data.treasure.models.TreasureItemDto
import com.example.sot_treasure_tracker.domain.models.Price
import com.example.sot_treasure_tracker.domain.models.SellBuckets

object CatalogAthenaFortune {
    val treasure: List<TreasureCategoryDto> = listOf(
        TreasureCategoryDto(
            titleId = R.string.title_athenas_chests,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.chest_of_legends,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE,
                    price = Price.GoldRange(8600..11000),
                    emissaryValue = 10800
                ),
                TreasureItemDto(
                    titleId = R.string.ashen_chest_of_legends,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE,
                    price = Price.GoldRange(13000..15000),
                    emissaryValue = 16200
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_athenas_artefacts,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.gilded_relic_of_ancient_fortune,
                    price = Price.GoldRange(1400..1550),
                    emissaryValue = 2160,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.chalice_of_ancient_fortune,
                    price = Price.GoldRange(570..620),
                    emissaryValue = 1080,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_athenas_skulls,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.villainous_skull_of_ancient_fortune,
                    price = Price.GoldRange(1400..1550),
                    emissaryValue = 2160,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.skull_of_ancient_fortune,
                    price = Price.GoldRange(570..620),
                    emissaryValue = 1080,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.skull_of_destiny,
                    price = Price.GoldRange(1000..1000),
                    emissaryValue = 0,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_athenas_trade_goods,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.keg_of_ancient_black_powder,
                    price = Price.GoldRange(3000..5000),
                    emissaryValue = 4320,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.crate_of_legendary_voyages,
                    price = Price.GoldRange(2100..2200),
                    emissaryValue = 1080,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_athenas_legend_of_the_veil_treasure,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.skull_of_athenas_blessing,
                    price = Price.GoldRange(3550..3850),
                    emissaryValue = 2700,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.athenas_relic,
                    price = Price.GoldRange(3550..3800),
                    emissaryValue = 2700,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.artifact_of_legendary_hunger,
                    price = Price.GoldRange(2500..2750),
                    emissaryValue = 4400,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.legendary_fortune_keeper,
                    price = Price.GoldRange(2500..2750),
                    emissaryValue = 0,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.offering_of_legendary_goods,
                    price = Price.GoldRange(2500..2750),
                    emissaryValue = 2400,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.jar_of_athenas_incense,
                    price = Price.GoldRange(1400..1550),
                    emissaryValue = 1800,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_raid_treasures,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.talisman_of_magnificent_fortunes,
                    price = Price.GoldRange(
                        15000..15000
                    ),
                    emissaryValue = 45000,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.talisman_of_great_fortunes,
                    price = Price.GoldRange(
                        10000..10000
                    ),
                    emissaryValue = 30000,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    titleId = R.string.talisman_of_fortunes,
                    price = Price.GoldRange(5000..5000),
                    emissaryValue = 15000,
                    belongsTo = SellBuckets.ATHENAS_FORTUNE
                )
            )
        )
    )
}
