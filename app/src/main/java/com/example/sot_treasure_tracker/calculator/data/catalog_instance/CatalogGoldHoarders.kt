package com.example.sot_treasure_tracker.calculator.data.catalog_instance

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.data.models.TreasureCategoryDto
import com.example.sot_treasure_tracker.calculator.data.models.TreasureItemDto
import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.models.SellBuckets

object CatalogGoldHoarders {
    val treasure: List<TreasureCategoryDto> = listOf(
        TreasureCategoryDto(
            titleId = R.string.title_regular_chests,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gh_kings_chest,
                    price = Price.GoldRange(3000..3100),
                    emissaryValue = 9150,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_barons_chest,
                    price = Price.GoldRange(2000..2050),
                    emissaryValue = 6075,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_admirals_chest,
                    price = Price.GoldRange(1525..1575),
                    emissaryValue = 4650,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_sea_masters_chest,
                    price = Price.GoldRange(1500..1550),
                    emissaryValue = 4575,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_sailors_chest,
                    price = Price.GoldRange(1000..1050),
                    emissaryValue = 3075,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_captains_chest,
                    price = Price.GoldRange(560..1100),
                    emissaryValue = 2400,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_marauders_chest,
                    price = Price.GoldRange(280..520),
                    emissaryValue = 1200,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_seafarers_chest,
                    price = Price.GoldRange(140..260),
                    emissaryValue = 600,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_castaways_chest,
                    price = Price.GoldRange(60..130),
                    emissaryValue = 300,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_regular_artefacts,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gh_crown_of_hope,
                    price = Price.GoldRange(3100..3200),
                    emissaryValue = 9450,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_cradle_od_virture,
                    price = Price.GoldRange(2215..2235),
                    emissaryValue = 6675,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_vestige_of_power,
                    price = Price.GoldRange(1655..1675),
                    emissaryValue = 4995,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_jeweled_regular_artefacts,
                    price = Price.GoldRange(560..1100),
                    emissaryValue = 2400,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_gold_regular_artefacts,
                    price = Price.GoldRange(280..520),
                    emissaryValue = 1200,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_silver_regular_artefacts,
                    price = Price.GoldRange(140..260),
                    emissaryValue = 600,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_bronze_regular_artefacts,
                    price = Price.GoldRange(60..130),
                    emissaryValue = 300,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_encounter_and_quest_chests,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gh_chest_of_fortune,
                    price = Price.GoldRange(
                        20000..20000
                    ),
                    emissaryValue = 50000,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_chest_of_ancient_tributes,
                    price = Price.GoldRange(3400..3900),
                    emissaryValue = 9720,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_stronghold_chest,
                    price = Price.GoldRange(1500..3000),
                    emissaryValue = 12000,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_skeleton_captains_chest,
                    price = Price.GoldRange(1150..1550),
                    emissaryValue = 6000,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_chest_of_the_damned,
                    price = Price.GoldRange(1000..1160),
                    emissaryValue = 3300,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_cursed_chests,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gh_chest_of_boundless_sorrow,
                    price = Price.GoldRange(6000..6800),
                    emissaryValue = 0,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_chest_of_everlasting_sorrow,
                    price = Price.GoldRange(6000..6800),
                    emissaryValue = 0,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_chest_of_rage,
                    price = Price.GoldRange(3000..3500),
                    emissaryValue = 9720,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_chest_of_sorrow,
                    price = Price.GoldRange(3000..3500),
                    emissaryValue = 9720,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_chest_of_a_thousand_grogs,
                    price = Price.GoldRange(2200..2600),
                    emissaryValue = 7200,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_raid_treasures,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gh_glittering_hoarders_reliquary,
                    price = Price.GoldRange(
                        15000..15000
                    ),
                    emissaryValue = 45000,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_prosperous_hoarders_reliquary,
                    price = Price.GoldRange(
                        10000..10000
                    ),
                    emissaryValue = 30000,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_hoarders_reliquary,
                    price = Price.GoldRange(5000..5000),
                    emissaryValue = 15000,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_ashen_chests,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gh_ashen_kings_chest,
                    price = Price.GoldRange(3700..3800),
                    emissaryValue = 11250,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_ashen_barons_chest,
                    price = Price.GoldRange(2250..2300),
                    emissaryValue = 6825,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_ashen_admirals_chest,
                    price = Price.GoldRange(1825..1875),
                    emissaryValue = 5550,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_ashen_sea_masters_chest,
                    price = Price.GoldRange(1700..1800),
                    emissaryValue = 5175,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_ashen_sailors_chest,
                    price = Price.GoldRange(1300..1350),
                    emissaryValue = 3975,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_ashen_captains_chest,
                    price = Price.GoldRange(1100..2100),
                    emissaryValue = 4800,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_ashen_marauders_chest,
                    price = Price.GoldRange(560..1100),
                    emissaryValue = 2400,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_ashen_seafarers_chest,
                    price = Price.GoldRange(280..520),
                    emissaryValue = 1200,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_ashen_castaways_chest,
                    price = Price.GoldRange(140..260),
                    emissaryValue = 600,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_devils_roar_artefacts,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gh_magmas_grail,
                    price = Price.GoldRange(1100..2100),
                    emissaryValue = 4800,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_devils_remnant,
                    price = Price.GoldRange(560..1100),
                    emissaryValue = 2400,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_brimstone_casket,
                    price = Price.GoldRange(280..520),
                    emissaryValue = 1200,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_roaring_goblet,
                    price = Price.GoldRange(140..260),
                    emissaryValue = 600,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_coral_chests,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gh_coral_captains_chest,
                    price = Price.GoldRange(980..1925),
                    emissaryValue = 4200,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_coral_marauders_chest,
                    price = Price.GoldRange(490..910),
                    emissaryValue = 2100,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_coral_seafarers_chest,
                    price = Price.GoldRange(245..455),
                    emissaryValue = 1050,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_coral_castaways_chest,
                    price = Price.GoldRange(105..230),
                    emissaryValue = 525,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_coral_artefacts,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gh_peculiar_coral_relic,
                    price = Price.GoldRange(980..1925),
                    emissaryValue = 4200,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_golden_coral_reliquary,
                    price = Price.GoldRange(490..910),
                    emissaryValue = 2100,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_silvered_coral_cup,
                    price = Price.GoldRange(245..455),
                    emissaryValue = 1050,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_mysterious_coral_vessel,
                    price = Price.GoldRange(105..230),
                    emissaryValue = 525,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_treasure_vault_keys,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.gh_gold_treasure_vault_key,
                    price = Price.GoldRange(3600..3750),
                    emissaryValue = 11325,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_silver_treasure_vault_key,
                    price = Price.GoldRange(2300..2400),
                    emissaryValue = 7305,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                ),
                TreasureItemDto(
                    nameId = R.string.gh_stone_treasure_vault_key,
                    price = Price.GoldRange(1200..1400),
                    emissaryValue = 4125,
                    belongsTo = SellBuckets.GOLD_HOARDERS
                )
            )
        )
    )
}
