package com.example.sot_treasure_tracker.tracker.data.catalog_pages

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.tracker.data.models.TreasureCategoryDto
import com.example.sot_treasure_tracker.tracker.data.models.TreasureItemDto
import com.example.sot_treasure_tracker.tracker.domain.models.Price
import com.example.sot_treasure_tracker.tracker.domain.models.SellFractions
import com.example.sot_treasure_tracker.tracker.domain.models.TreasurePage

object AthenaFortune : TreasurePage {
    override val page: List<TreasureCategoryDto> = listOf(
        TreasureCategoryDto(
            titleId = R.string.title_athenas_chests,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.chest_of_legends,
                    belongsTo = SellFractions.ATHENAS_FORTUNE,
                    price = Price.GoldRange(8600..11000),
                    emissaryValue = 10800
                ),
                TreasureItemDto(
                    nameId = R.string.ashen_chest_of_legends,
                    belongsTo = SellFractions.ATHENAS_FORTUNE,
                    price = Price.GoldRange(13000..15000),
                    emissaryValue = 16200
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_athenas_artefacts,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gilded_relic_of_ancient_fortune,
                    price = Price.GoldRange(1400..1550),
                    emissaryValue = 2160,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    nameId = R.string.chalice_of_ancient_fortune,
                    price = Price.GoldRange(570..620),
                    emissaryValue = 1080,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_athenas_skulls,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.villainous_skull_of_ancient_fortune,
                    price = Price.GoldRange(1400..1550),
                    emissaryValue = 2160,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    nameId = R.string.skull_of_ancient_fortune,
                    price = Price.GoldRange(570..620),
                    emissaryValue = 1080,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_athenas_trade_goods,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.keg_of_ancient_black_powder,
                    price = Price.GoldRange(3000..5000),
                    emissaryValue = 4320,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    nameId = R.string.crate_of_legendary_voyages,
                    price = Price.GoldRange(570..620),
                    emissaryValue = 1080,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_athenas_legend_of_the_veil_treasure,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.skull_of_athenas_blessing,
                    price = Price.GoldRange(3550..3850),
                    emissaryValue = 2700,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    nameId = R.string.athenas_relic,
                    price = Price.GoldRange(3500..3800),
                    emissaryValue = 2700,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    nameId = R.string.artifact_of_legendary_hunger,
                    price = Price.GoldRange(2500..2750),
                    emissaryValue = 4400,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    nameId = R.string.legendary_fortune_keeper,
                    price = Price.GoldRange(2500..2750),
                    emissaryValue = 0,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    nameId = R.string.offering_of_legendary_goods,
                    price = Price.GoldRange(2500..2750),
                    emissaryValue = 2400,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    nameId = R.string.jar_of_athenas_incense,
                    price = Price.GoldRange(1400..1550),
                    emissaryValue = 1800,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_raid_treasures,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.talisman_of_magnificent_fortunes,
                    price = Price.GoldRange(
                        15000..15000
                    ),
                    emissaryValue = 45000,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    nameId = R.string.talisman_of_great_fortunes,
                    price = Price.GoldRange(
                        10000..10000
                    ),
                    emissaryValue = 30000,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                ),
                TreasureItemDto(
                    nameId = R.string.talisman_of_fortunes,
                    price = Price.GoldRange(5000..5000),
                    emissaryValue = 15000,
                    belongsTo = SellFractions.ATHENAS_FORTUNE
                )
            )
        )
    )
}
