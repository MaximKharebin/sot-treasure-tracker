package com.example.sot_treasure_tracker.calculator.data

import com.example.sot_treasure_tracker.calculator.data.catalog_instance.CatalogAthenaFortune
import com.example.sot_treasure_tracker.calculator.data.catalog_instance.CatalogGoldHoarders
import com.example.sot_treasure_tracker.calculator.data.catalog_instance.CatalogMerchantAlliance
import com.example.sot_treasure_tracker.calculator.data.catalog_instance.CatalogOrderOfSouls
import com.example.sot_treasure_tracker.calculator.data.catalog_instance.CatalogOther
import com.example.sot_treasure_tracker.calculator.data.catalog_instance.CatalogReapersBones

object TreasureCatalogInstance {
    val catalog = listOf(
        CatalogGoldHoarders.treasure,
        CatalogOrderOfSouls.treasure,
        CatalogMerchantAlliance.treasure,
        CatalogAthenaFortune.treasure,
        CatalogReapersBones.treasure,
        CatalogOther.treasure
    )
}
