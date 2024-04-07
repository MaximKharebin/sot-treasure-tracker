package com.example.sot_treasure_tracker.tracker.data.catalog_pages

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.tracker.data.models.TreasureCategoryDto
import com.example.sot_treasure_tracker.tracker.data.models.TreasureItemDto
import com.example.sot_treasure_tracker.tracker.domain.models.Price
import com.example.sot_treasure_tracker.tracker.domain.models.SellFractions
import com.example.sot_treasure_tracker.tracker.domain.models.TreasurePage

object MerchantAlliance : TreasurePage {
    override val page: List<TreasureCategoryDto> = listOf(
        TreasureCategoryDto(
            titleId = R.string.title_regular_crates,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_immaculate_diamonds,
                    price = Price.GoldRange(3000..3100),
                    emissaryValue = 9150,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_exquisite_spices,
                    price = Price.GoldRange(1100..1900),
                    emissaryValue = 4320,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_exotic_silks,
                    price = Price.GoldRange(500..1000),
                    emissaryValue = 2160,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_rare_tea,
                    price = Price.GoldRange(260..470),
                    emissaryValue = 1080,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_fine_sugar,
                    price = Price.GoldRange(100..200),
                    emissaryValue = 540,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_encounter_and_quest_crates,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_ancient_bone_dust,
                    price = Price.GoldRange(2100..5400),
                    emissaryValue = 12960,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_ashes_of_the_damned,
                    price = Price.GoldRange(1150..1400),
                    emissaryValue = 3840,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_resource_crates,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_special_resource_crates,
                    price = Price.GoldRange(1000..2000),
                    emissaryValue = 3000,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_ghostly_resource_crates,
                    price = Price.GoldRange(900..1100),
                    emissaryValue = 3000,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_basic_resource_crates,
                    price = Price.GoldRange(600..1100),
                    emissaryValue = 3000,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_ammo_crate,
                    price = Price.GoldRange(280..520),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_the_dark_brethren,
                    price = Price.GoldRange(10..25),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_raid_treasures,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_scrolls_of_undiscovered_waters,
                    price = Price.GoldRange(
                        15000..15000
                    ),
                    emissaryValue = 45000,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_scrolls_of_shrouded_waters,
                    price = Price.GoldRange(
                        10000..10000
                    ),
                    emissaryValue = 30000,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_scrolls_of_charted_waters,
                    price = Price.GoldRange(5000..5000),
                    emissaryValue = 15000,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_explosives,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_stronghold_gunpowder_barrel,
                    price = Price.GoldRange(2750..6000),
                    emissaryValue = 12960,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_gunpowder_barrel,
                    price = Price.GoldRange(100..200),
                    emissaryValue = 432,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_merchant_manifests,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_revered_merchant_manifest,
                    price = Price.GoldRange(4000..4000),
                    emissaryValue = 12000,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_eminent_merchant_manifest,
                    price = Price.GoldRange(3000..3000),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_esteemed_merchant_manifest,
                    price = Price.GoldRange(2500..2500),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_prosperous_merchant_manifest,
                    price = Price.GoldRange(2000..2000),
                    emissaryValue = 5000,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_captains_key,
                    price = Price.GoldRange(2500..2500),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_devils_roar_crates,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_precious_gemstones,
                    price = Price.GoldRange(2100..3600),
                    emissaryValue = 8640,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_extraordinary_minerals,
                    price = Price.GoldRange(1100..1900),
                    emissaryValue = 4320,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_fine_ore,
                    price = Price.GoldRange(500..1000),
                    emissaryValue = 2160,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_crate_of_volcanic_stoner,
                    price = Price.GoldRange(260..470),
                    emissaryValue = 1080,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_coffers,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_coffer_of_forgotten_jewels,
                    price = Price.GoldRange(1100..1900),
                    emissaryValue = 4320,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_coffer_of_timeworn_metals,
                    price = Price.GoldRange(500..1000),
                    emissaryValue = 2160,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_coffer_of_antiquated_coffee,
                    price = Price.GoldRange(260..470),
                    emissaryValue = 1080,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_coffer_of_aged_grog,
                    price = Price.GoldRange(100..200),
                    emissaryValue = 540,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_commodities,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_unclassified_gemstones,
                    price = Price.GoldRange(120..900),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_unfiltered_minerals,
                    price = Price.GoldRange(110..850),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_broken_stone,
                    price = Price.GoldRange(105..800),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_unrefined_spices,
                    price = Price.GoldRange(100..750),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_unsorted_silks,
                    price = Price.GoldRange(90..700),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_ungraded_tea,
                    price = Price.GoldRange(85..650),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_raw_sugar,
                    price = Price.GoldRange(80..600),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_cargo,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_kings_cargo,
                    price = Price.GoldRange(0..1655),
                    emissaryValue = 4950,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_regular_cargo,
                    price = Price.GoldRange(100..700),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_devils_roar_cargo,
                    price = Price.GoldRange(200..1400),
                    emissaryValue = 0,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_animals,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ma_tier4_animals,
                    price = Price.GoldRange(1550..2800),
                    emissaryValue = 6280,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_tier3_animals,
                    price = Price.GoldRange(750..1400),
                    emissaryValue = 3240,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_tier2_animals,
                    price = Price.GoldRange(350..700),
                    emissaryValue = 1620,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItemDto(
                    nameId = R.string.ma_tier1_animals,
                    price = Price.GoldRange(100..250),
                    emissaryValue = 810,
                    belongsTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        )
    )
}
