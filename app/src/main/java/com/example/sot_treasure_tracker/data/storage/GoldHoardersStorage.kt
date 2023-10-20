package com.example.sot_treasure_tracker.data.storage

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.model.Price
import com.example.sot_treasure_tracker.data.model.TreasureCategory
import com.example.sot_treasure_tracker.data.TreasureList
import com.example.sot_treasure_tracker.data.model.Fraction
import com.example.sot_treasure_tracker.data.model.Treasure

object GoldHoardersStorage : TreasureList {
    override val treasure = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_regular_chests,
            categoryItems = listOf(
                Treasure(
                    name = R.string.chest_captains_chest,
                    price = Price.Gold(560..1100),
                    emissaryValue = 2400,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_marauders_chest,
                    price = Price.Gold(280..520),
                    emissaryValue = 1200,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_seafarers_chest,
                    price = Price.Gold(140..260),
                    emissaryValue = 600,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_castaways_chest,
                    price = Price.Gold(60..130),
                    emissaryValue = 300,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_ashen_chests,
            categoryItems = listOf(
                Treasure(
                    name = R.string.chest_ashen_captains_chest,
                    price = Price.Gold(1100..2100),
                    emissaryValue = 4800,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_ashen_marauders_chest,
                    price = Price.Gold(560..1100),
                    emissaryValue = 2400,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_ashen_seafarers_chest,
                    price = Price.Gold(280..520),
                    emissaryValue = 1200,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_ashen_castaways_chest,
                    price = Price.Gold(140..260),
                    emissaryValue = 600,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_coral_chests,
            categoryItems = listOf(
                Treasure(
                    name = R.string.chest_coral_captains_chest,
                    price = Price.Gold(980..1925),
                    emissaryValue = 4200,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_coral_marauders_chest,
                    price = Price.Gold(490..910),
                    emissaryValue = 2100,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_coral_seafarers_chest,
                    price = Price.Gold(245..455),
                    emissaryValue = 1050,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_coral_castaways_chest,
                    price = Price.Gold(105..230),
                    emissaryValue = 525,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_valuable_chests,
            categoryItems = listOf(
                Treasure(
                    name = R.string.chest_valuable_chest_of_ancient_tributes,
                    price = Price.Gold(3400..3900),
                    emissaryValue = 9750,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_valuable_stronghold_chest,
                    price = Price.Gold(1500..3000),
                    emissaryValue = 12000,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_valuable_skeleton_captains_chest,
                    price = Price.Gold(1150..1550),
                    emissaryValue = 6000,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_valuable_chest_of_the_damned,
                    price = Price.Gold(1000..1160),
                    emissaryValue = 3300,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_cursed_chests,
            categoryItems = listOf(
                Treasure(
                    name = R.string.chest_cursed_chest_of_rage,
                    price = Price.Gold(3000..3500),
                    emissaryValue = 9720,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_cursed_chest_of_sorrow,
                    price = Price.Gold(3000..3500),
                    emissaryValue = 9720,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.chest_cursed_chest_of_a_thousand_grogs,
                    price = Price.Gold(2200..2600),
                    emissaryValue = 7200,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_jeweled_artefacts,
            categoryItems = listOf(
                Treasure(
                    name = R.string.artefact_jeweled_regular,
                    price = Price.Gold(560..1100),
                    emissaryValue = 2400,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.artefact_peculiar_coral_relic,
                    price = Price.Gold(980..1925),
                    emissaryValue = 4200,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.artefact_magmas_grail,
                    price = Price.Gold(1100..2100),
                    emissaryValue = 4800,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_gold_artefacts,
            categoryItems = listOf(
                Treasure(
                    name = R.string.artefact_gold_regular,
                    price = Price.Gold(280..520),
                    emissaryValue = 1200,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.artefact_golden_coral_reliquary,
                    price = Price.Gold(490..910),
                    emissaryValue = 2100,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.artefact_devils_remnant,
                    price = Price.Gold(560..1100),
                    emissaryValue = 2400,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_silver_artefacts,
            categoryItems = listOf(
                Treasure(
                    name = R.string.artefact_silver_regular,
                    price = Price.Gold(140..260),
                    emissaryValue = 600,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.artefact_silvered_coral_cup,
                    price = Price.Gold(245..455),
                    emissaryValue = 1050,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.artefact_brimstone_casket,
                    price = Price.Gold(280..520),
                    emissaryValue = 1200,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_bronze_artefacts,
            categoryItems = listOf(
                Treasure(
                    name = R.string.artefact_bronze_regular,
                    price = Price.Gold(60..130),
                    emissaryValue = 300,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.artefact_mysterious_coral_vessel,
                    price = Price.Gold(105..228),
                    emissaryValue = 525,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
                Treasure(
                    name = R.string.artefact_roaring_goblet,
                    price = Price.Gold(140..260),
                    emissaryValue = 600,
                    canSellTo = listOf(Fraction.GOLD_HOARDERS, Fraction.REAPERS_BONES)
                ),
            )
        ),
    )
}
