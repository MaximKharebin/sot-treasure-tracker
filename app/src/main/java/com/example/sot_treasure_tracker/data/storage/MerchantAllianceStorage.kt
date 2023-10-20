package com.example.sot_treasure_tracker.data.storage

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.Price
import com.example.sot_treasure_tracker.data.TreasureCategory
import com.example.sot_treasure_tracker.data.TreasureList
import com.example.sot_treasure_tracker.data.model.MerchantAllianceTreasure

object MerchantAllianceStorage : TreasureList<MerchantAllianceTreasure> {
    override val treasure = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_regular_crates,
            categoryItems = listOf(
                MerchantAllianceTreasure(
                    name = R.string.crate_of_exquisite_spices,
                    price = Price.Gold(1100..1900),
                    emissaryValue = 4320,
                ),
                MerchantAllianceTreasure(
                    name = R.string.crate_of_exotic_silks,
                    price = Price.Gold(500..1000),
                    emissaryValue = 2160,
                ),
                MerchantAllianceTreasure(
                    name = R.string.crate_of_rare_tea,
                    price = Price.Gold(260..470),
                    emissaryValue = 1080,
                ),
                MerchantAllianceTreasure(
                    name = R.string.crate_of_fine_sugar,
                    price = Price.Gold(100..200),
                    emissaryValue = 540,
                ),
            )
        ),
        TreasureCategory(
            categoryTitle = R.string.title_devils_roar_crates,
            categoryItems = listOf(
                MerchantAllianceTreasure(
                    name = R.string.crate_of_precious_gemstones,
                    price = Price.Gold(2100..3600),
                    emissaryValue = 8640,
                ),
                MerchantAllianceTreasure(
                    name = R.string.crate_of_extraordinary_minerals,
                    price = Price.Gold(1100..1900),
                    emissaryValue = 4320,
                ),
                MerchantAllianceTreasure(
                    name = R.string.crate_of_fine_ore,
                    price = Price.Gold(500..1000),
                    emissaryValue = 2160,
                ),
                MerchantAllianceTreasure(
                    name = R.string.crate_of_volcanic_stoner,
                    price = Price.Gold(260..470),
                    emissaryValue = 1080,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_coral_coffers,
            categoryItems = listOf(
                MerchantAllianceTreasure(
                    name = R.string.coffer_of_forgotten_jewels,
                    price = Price.Gold(1100..1900),
                    emissaryValue = 4320,
                ),
                MerchantAllianceTreasure(
                    name = R.string.coffer_of_timeworn_metals,
                    price = Price.Gold(500..1000),
                    emissaryValue = 2160,
                ),
                MerchantAllianceTreasure(
                    name = R.string.coffer_of_antiquated_coffee,
                    price = Price.Gold(260..470),
                    emissaryValue = 1080,
                ),
                MerchantAllianceTreasure(
                    name = R.string.coffer_of_aged_grog,
                    price = Price.Gold(100..200),
                    emissaryValue = 540,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_valuable_crates,
            categoryItems = listOf(
                MerchantAllianceTreasure(
                    name = R.string.crate_of_ancient_bone_dust,
                    price = Price.Gold(2100..5400),
                    emissaryValue = 12960,
                ),
                MerchantAllianceTreasure(
                    name = R.string.ashes_of_the_damned,
                    price = Price.Gold(1150..1400),
                    emissaryValue = 3840,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_resource_crates,
            categoryItems = listOf(
                MerchantAllianceTreasure(
                    name = R.string.basic_resource_crate,
                    price = Price.Gold(600..1100),
                    emissaryValue = 3000,
                ),
                MerchantAllianceTreasure(
                    name = R.string.storage_crate_of_the_damned,
                    price = Price.Gold(900..1100),
                    emissaryValue = 3000,
                ),
                MerchantAllianceTreasure(
                    name = R.string.cannonball_crate_of_the_damned,
                    price = Price.Gold(900..1100),
                    emissaryValue = 3000,
                ),
                MerchantAllianceTreasure(
                    name = R.string.firework_crate,
                    price = Price.Gold(1000..2000),
                    emissaryValue = 3000,
                ),
                MerchantAllianceTreasure(
                    name = R.string.firebomb_crate,
                    price = Price.Gold(1100..2000),
                    emissaryValue = 3000,
                ),
                MerchantAllianceTreasure(
                    name = R.string.ammo_crate,
                    price = Price.Gold(280..520),
                    emissaryValue = 0,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_regular_cargo,
            categoryItems = listOf(
                MerchantAllianceTreasure(
                    name = R.string.crate_of_plants,
                    price = Price.Gold(100..700),
                    emissaryValue = 0,
                ),
                MerchantAllianceTreasure(
                    name = R.string.crate_of_luxurious_cloth,
                    price = Price.Gold(100..700),
                    emissaryValue = 0,
                ),
                MerchantAllianceTreasure(
                    name = R.string.crate_of_rum_bottles,
                    price = Price.Gold(100..700),
                    emissaryValue = 0,
                ),
            )
        ),
        TreasureCategory(
            categoryTitle = R.string.title_devils_roar_cargo,
            categoryItems = listOf(
                MerchantAllianceTreasure(
                    name = R.string.crate_of_devils_plants,
                    price = Price.Gold(200..1400),
                    emissaryValue = 0,
                ),
                MerchantAllianceTreasure(
                    name = R.string.crate_of_devils_luxurious_cloth,
                    price = Price.Gold(200..1400),
                    emissaryValue = 0,
                ),
                MerchantAllianceTreasure(
                    name = R.string.crate_of_devils_rum_bottles,
                    price = Price.Gold(200..1400),
                    emissaryValue = 0,
                ),
            )
        ),
    )
}