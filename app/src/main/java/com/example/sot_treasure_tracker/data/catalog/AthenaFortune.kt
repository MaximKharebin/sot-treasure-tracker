package com.example.sot_treasure_tracker.data.catalog

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.Price
import com.example.sot_treasure_tracker.data.models.TreasureCategory
import com.example.sot_treasure_tracker.data.models.Treasure
import com.example.sot_treasure_tracker.components.Fraction
import com.example.sot_treasure_tracker.data.models.TreasureItem

object AthenaFortune : Treasure {
    override val treasure: List<TreasureCategory> = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_athenas_chests,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.chest_of_legends,
                    price = Price.Gold(8600..11000) ,
                    emissaryValue = 10800,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
                TreasureItem(
                    name = R.string.ashen_chest_of_legends,
                    price = Price.Gold(13000..15000),
                    emissaryValue = 16200,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_athenas_artefacts,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gilded_relic_of_ancient_fortune,
                    price = Price.Gold(1400..1550),
                    emissaryValue = 2160,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
                TreasureItem(
                    name = R.string.chalice_of_ancient_fortune,
                    price = Price.Gold(570..620),
                    emissaryValue = 1080,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_athenas_skulls,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.villainous_skull_of_ancient_fortune,
                    price = Price.Gold(1400..1550),
                    emissaryValue = 2160,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
                TreasureItem(
                    name = R.string.skull_of_ancient_fortune,
                    price = Price.Gold(570..620),
                    emissaryValue = 1080,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_athenas_trade_goods,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.keg_of_ancient_black_powder,
                    price = Price.Gold(3000..5000),
                    emissaryValue = 4320,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
                TreasureItem(
                    name = R.string.crate_of_legendary_voyages,
                    price = Price.Gold(570..620),
                    emissaryValue = 1080,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_athenas_legend_of_the_veil_treasure,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.skull_of_athenas_blessing,
                    price = Price.Gold(3550..3850),
                    emissaryValue = 2700,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
                TreasureItem(
                    name = R.string.athenas_relic,
                    price = Price.Gold(3500..3800),
                    emissaryValue = 2700,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
                TreasureItem(
                    name = R.string.artifact_of_legendary_hunger,
                    price = Price.Gold(2500..2750),
                    emissaryValue = 4400,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
                TreasureItem(
                    name = R.string.legendary_fortune_keeper,
                    price = Price.Gold(2500..2750),
                    emissaryValue = 0,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
                TreasureItem(
                    name = R.string.offering_of_legendary_goods,
                    price = Price.Gold(2500..2750),
                    emissaryValue = 2400,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
                TreasureItem(
                    name = R.string.jar_of_athenas_incense,
                    price = Price.Gold(1400..1550),
                    emissaryValue = 1800,
                    canSellTo = Fraction.ATHENAS_FORTUNE
                ),
            )
        ),
    )
}
