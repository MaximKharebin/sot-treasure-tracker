package com.example.sot_treasure_tracker.data.treasure

import com.example.sot_treasure_tracker.data.treasure.catalog_instance.CatalogAthenaFortune
import com.example.sot_treasure_tracker.data.treasure.catalog_instance.CatalogGoldHoarders
import com.example.sot_treasure_tracker.data.treasure.catalog_instance.CatalogMerchantAlliance
import com.example.sot_treasure_tracker.data.treasure.catalog_instance.CatalogOrderOfSouls
import com.example.sot_treasure_tracker.data.treasure.catalog_instance.CatalogOther
import com.example.sot_treasure_tracker.data.treasure.catalog_instance.CatalogReapersBones

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
