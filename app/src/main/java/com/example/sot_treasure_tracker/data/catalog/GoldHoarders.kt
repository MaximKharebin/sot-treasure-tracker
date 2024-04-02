package com.example.sot_treasure_tracker.data.catalog

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.Price
import com.example.sot_treasure_tracker.data.models.TreasureCategory
import com.example.sot_treasure_tracker.data.models.Treasure
import com.example.sot_treasure_tracker.components.SellFractions
import com.example.sot_treasure_tracker.data.models.TreasureItem

object GoldHoarders : Treasure {
    override val treasure: List<TreasureCategory> = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_regular_chests,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gh_kings_chest,
                    price = Price.Gold(3000..3100),
                    emissaryValue = 9150,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_barons_chest,
                    price = Price.Gold(2000..2050),
                    emissaryValue = 6075,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_admirals_chest,
                    price = Price.Gold(1525..1575),
                    emissaryValue = 4650,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_sea_masters_chest,
                    price = Price.Gold(1500..1550),
                    emissaryValue = 4575,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_sailors_chest,
                    price = Price.Gold(1000..1050),
                    emissaryValue = 3075,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_captains_chest,
                    price = Price.Gold(560..1100),
                    emissaryValue = 2400,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_marauders_chest,
                    price = Price.Gold(280..520),
                    emissaryValue = 1200,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_seafarers_chest,
                    price = Price.Gold(140..260),
                    emissaryValue = 600,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_castaways_chest,
                    price = Price.Gold(60..130),
                    emissaryValue = 300,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_regular_artefacts,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gh_jeweled_regular_artefacts,
                    price = Price.Gold(560..1100),
                    emissaryValue = 2400,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_gold_regular_artefacts,
                    price = Price.Gold(280..520),
                    emissaryValue = 1200,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_silver_regular_artefacts,
                    price = Price.Gold(140..260),
                    emissaryValue = 600,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_bronze_regular_artefacts,
                    price = Price.Gold(60..130),
                    emissaryValue = 300,
                    canSellTo = SellFractions.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_encounter_and_quest_chests,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gh_chest_of_fortune,
                    price = Price.Gold(20000..20000),
                    emissaryValue = 50000,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_chest_of_ancient_tributes,
                    price = Price.Gold(3400..3900),
                    emissaryValue = 9720,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_stronghold_chest,
                    price = Price.Gold(1500..3000),
                    emissaryValue = 12000,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_skeleton_captains_chest,
                    price = Price.Gold(1150..1550),
                    emissaryValue = 6000,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_chest_of_the_damned,
                    price = Price.Gold(1000..1160),
                    emissaryValue = 3300,
                    canSellTo = SellFractions.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_cursed_chests,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gh_chest_of_boundless_sorrow,
                    price = Price.Gold(6000..6800),
                    emissaryValue = 0,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_chest_of_everlasting_sorrow,
                    price = Price.Gold(6000..6800),
                    emissaryValue = 0,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_chest_of_rage,
                    price = Price.Gold(3000..3500),
                    emissaryValue = 9720,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_chest_of_sorrow,
                    price = Price.Gold(3000..3500),
                    emissaryValue = 9720,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_chest_of_a_thousand_grogs,
                    price = Price.Gold(2200..2600),
                    emissaryValue = 7200,
                    canSellTo = SellFractions.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_raid_treasures,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gh_glittering_hoarders_reliquary,
                    price = Price.Gold(15000..15000),
                    emissaryValue = 45000,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_prosperous_hoarders_reliquary,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 30000,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_hoarders_reliquary,
                    price = Price.Gold(5000..5000),
                    emissaryValue = 15000,
                    canSellTo = SellFractions.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_ashen_chests,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gh_ashen_kings_chest,
                    price = Price.Gold(3700..3800),
                    emissaryValue = 11250,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_ashen_barons_chest,
                    price = Price.Gold(2250..2300),
                    emissaryValue = 6825,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_ashen_admirals_chest,
                    price = Price.Gold(1825..1875),
                    emissaryValue = 5550,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_ashen_sea_masters_chest,
                    price = Price.Gold(1700..1800),
                    emissaryValue = 5175,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_ashen_sailors_chest,
                    price = Price.Gold(1300..1350),
                    emissaryValue = 3975,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_ashen_captains_chest,
                    price = Price.Gold(1100..2100),
                    emissaryValue = 4800,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_ashen_marauders_chest,
                    price = Price.Gold(560..1100),
                    emissaryValue = 2400,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_ashen_seafarers_chest,
                    price = Price.Gold(280..520),
                    emissaryValue = 1200,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_ashen_castaways_chest,
                    price = Price.Gold(140..260),
                    emissaryValue = 600,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_devils_roar_artefacts,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gh_magmas_grail,
                    price = Price.Gold(1100..2100),
                    emissaryValue = 4800,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_devils_remnant,
                    price = Price.Gold(560..1100),
                    emissaryValue = 2400,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_brimstone_casket,
                    price = Price.Gold(280..520),
                    emissaryValue = 1200,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_roaring_goblet,
                    price = Price.Gold(140..260),
                    emissaryValue = 600,
                    canSellTo = SellFractions.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_coral_chests,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gh_coral_captains_chest,
                    price = Price.Gold(980..1925),
                    emissaryValue = 4200,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_coral_marauders_chest,
                    price = Price.Gold(490..910),
                    emissaryValue = 2100,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_coral_seafarers_chest,
                    price = Price.Gold(245..455),
                    emissaryValue = 1050,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_coral_castaways_chest,
                    price = Price.Gold(105..230),
                    emissaryValue = 525,
                    canSellTo = SellFractions.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_coral_artefacts,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gh_peculiar_coral_relic,
                    price = Price.Gold(980..1925),
                    emissaryValue = 4200,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_golden_coral_reliquary,
                    price = Price.Gold(490..910),
                    emissaryValue = 2100,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_silvered_coral_cup,
                    price = Price.Gold(245..455),
                    emissaryValue = 1050,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_mysterious_coral_vessel,
                    price = Price.Gold(105..230),
                    emissaryValue = 525,
                    canSellTo = SellFractions.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_treasure_vault_keys,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.gh_gold_treasure_vault_key,
                    price = Price.Gold(3600..3750),
                    emissaryValue = 11325,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_silver_treasure_vault_key,
                    price = Price.Gold(2300..2400),
                    emissaryValue = 7305,
                    canSellTo = SellFractions.GOLD_HOARDERS
                ),
                TreasureItem(
                    name = R.string.gh_stone_treasure_vault_key,
                    price = Price.Gold(1200..1400),
                    emissaryValue = 4125,
                    canSellTo = SellFractions.GOLD_HOARDERS
                )
            )
        )
    )
}
