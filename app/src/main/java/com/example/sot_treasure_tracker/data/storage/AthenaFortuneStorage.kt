package com.example.sot_treasure_tracker.data.storage

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.Price
import com.example.sot_treasure_tracker.data.TreasureCategory
import com.example.sot_treasure_tracker.data.TreasureList
import com.example.sot_treasure_tracker.data.model.AthenaFortuneTreasure

object AthenaFortuneStorage : TreasureList<AthenaFortuneTreasure> {
    override val treasure = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_athenas_chests,
            categoryItems = listOf(
                AthenaFortuneTreasure(
                    name = R.string.chest_of_legends,
                    price = Price.Gold(8600..11000) ,
                    emissaryValue = 10800,
                ),
                AthenaFortuneTreasure(
                    name = R.string.ashen_chest_of_legends,
                    price = Price.Gold(13000..15000),
                    emissaryValue = 16200,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_athenas_artefacts,
            categoryItems = listOf(
                AthenaFortuneTreasure(
                    name = R.string.gilded_relic_of_ancient_fortune,
                    price = Price.Gold(1400..1550),
                    emissaryValue = 2160,
                ),
                AthenaFortuneTreasure(
                    name = R.string.chalice_of_ancient_fortune,
                    price = Price.Gold(570..620),
                    emissaryValue = 1080,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_athenas_skulls,
            categoryItems = listOf(
                AthenaFortuneTreasure(
                    name = R.string.villainous_skull_of_ancient_fortune,
                    price = Price.Gold(1400..1550),
                    emissaryValue = 2160,
                ),
                AthenaFortuneTreasure(
                    name = R.string.skull_of_ancient_fortune,
                    price = Price.Gold(570..620),
                    emissaryValue = 1080,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_athenas_trade_goods,
            categoryItems = listOf(
                AthenaFortuneTreasure(
                    name = R.string.keg_of_ancient_black_powder,
                    price = Price.Gold(3000..5000),
                    emissaryValue = 4320,
                ),
                AthenaFortuneTreasure(
                    name = R.string.crate_of_legendary_voyages,
                    price = Price.Gold(570..620),
                    emissaryValue = 1080,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_athenas_legend_of_the_veil_treasure,
            categoryItems = listOf(
                AthenaFortuneTreasure(
                    name = R.string.skull_of_athenas_blessing,
                    price = Price.Gold(3550..3850),
                    emissaryValue = 2700,
                ),
                AthenaFortuneTreasure(
                    name = R.string.athenas_relic,
                    price = Price.Gold(3500..3800),
                    emissaryValue = 2700,
                ),
                AthenaFortuneTreasure(
                    name = R.string.artifact_of_legendary_hunger,
                    price = Price.Gold(2500..2750),
                    emissaryValue = 4400,
                ),
                AthenaFortuneTreasure(
                    name = R.string.legendary_fortune_keeper,
                    price = Price.Gold(2500..2750),
                    emissaryValue = 0,
                ),
                AthenaFortuneTreasure(
                    name = R.string.offering_of_legendary_goods,
                    price = Price.Gold(2500..2750),
                    emissaryValue = 2400,
                ),
                AthenaFortuneTreasure(
                    name = R.string.jar_of_athenas_incense,
                    price = Price.Gold(1400..1550),
                    emissaryValue = 1800,
                ),
            )
        ),
    )
}
