package com.example.sot_treasure_tracker.data.catalog

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.Price
import com.example.sot_treasure_tracker.data.models.TreasureCategory
import com.example.sot_treasure_tracker.data.models.Treasure
import com.example.sot_treasure_tracker.components.SellFractions
import com.example.sot_treasure_tracker.data.models.TreasureItem

object MerchantAlliance : Treasure {
    override val treasure: List<TreasureCategory> = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_regular_crates,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ma_crate_of_immaculate_diamonds,
                    price = Price.Gold(3000..3100),
                    emissaryValue = 9150,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_crate_of_exquisite_spices,
                    price = Price.Gold(1100..1900),
                    emissaryValue = 4320,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_crate_of_exotic_silks,
                    price = Price.Gold(500..1000),
                    emissaryValue = 2160,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_crate_of_rare_tea,
                    price = Price.Gold(260..470),
                    emissaryValue = 1080,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_crate_of_fine_sugar,
                    price = Price.Gold(100..200),
                    emissaryValue = 540,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_encounter_and_quest_crates,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ma_crate_of_ancient_bone_dust,
                    price = Price.Gold(2100..5400),
                    emissaryValue = 12960,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_ashes_of_the_damned,
                    price = Price.Gold(1150..1400),
                    emissaryValue = 3840,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_resource_crates,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ma_special_resource_crates,
                    price = Price.Gold(1000..2000),
                    emissaryValue = 3000,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_ghostly_resource_crates,
                    price = Price.Gold(900..1100),
                    emissaryValue = 3000,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_basic_resource_crates,
                    price = Price.Gold(600..1100),
                    emissaryValue = 3000,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_ammo_crate,
                    price = Price.Gold(280..520),
                    emissaryValue = 0,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_crate_of_the_dark_brethren,
                    price = Price.Gold(10..25),
                    emissaryValue = 0,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_raid_treasures,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ma_scrolls_of_undiscovered_waters,
                    price = Price.Gold(15000..15000),
                    emissaryValue = 45000,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_scrolls_of_shrouded_waters,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 30000,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_scrolls_of_charted_waters,
                    price = Price.Gold(5000..5000),
                    emissaryValue = 15000,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_explosives,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ma_stronghold_gunpowder_barrel,
                    price = Price.Gold(2750..6000),
                    emissaryValue = 12960,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_gunpowder_barrel,
                    price = Price.Gold(100..200),
                    emissaryValue = 432,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_merchant_manifests,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ma_revered_merchant_manifest,
                    price = Price.Gold(4000..4000),
                    emissaryValue = 12000,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_eminent_merchant_manifest,
                    price = Price.Gold(3000..3000),
                    emissaryValue = 0,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_esteemed_merchant_manifest,
                    price = Price.Gold(2500..2500),
                    emissaryValue = 0,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_prosperous_merchant_manifest,
                    price = Price.Gold(2000..2000),
                    emissaryValue = 5000,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_devils_roar_crates,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ma_crate_of_precious_gemstones,
                    price = Price.Gold(2100..3600),
                    emissaryValue = 8640,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_crate_of_extraordinary_minerals,
                    price = Price.Gold(1100..1900),
                    emissaryValue = 4320,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_crate_of_fine_ore,
                    price = Price.Gold(500..1000),
                    emissaryValue = 2160,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_crate_of_volcanic_stoner,
                    price = Price.Gold(260..470),
                    emissaryValue = 1080,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_coffers,
            categoryItems = listOf(
                TreasureItem(
                    name = R.string.ma_coffer_of_forgotten_jewels,
                    price = Price.Gold(1100..1900),
                    emissaryValue = 4320,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_coffer_of_timeworn_metals,
                    price = Price.Gold(500..1000),
                    emissaryValue = 2160,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_coffer_of_antiquated_coffee,
                    price = Price.Gold(260..470),
                    emissaryValue = 1080,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                ),
                TreasureItem(
                    name = R.string.ma_coffer_of_aged_grog,
                    price = Price.Gold(100..200),
                    emissaryValue = 540,
                    canSellTo = SellFractions.MERCHANT_ALLIANCE
                )
            )
        )
    )
}