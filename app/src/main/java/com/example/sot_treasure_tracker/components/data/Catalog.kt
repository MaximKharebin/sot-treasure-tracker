package com.example.sot_treasure_tracker.components.data

import com.example.sot_treasure_tracker.components.data.catalog_pages.AthenaFortune
import com.example.sot_treasure_tracker.components.data.catalog_pages.GoldHoarders
import com.example.sot_treasure_tracker.components.data.catalog_pages.MerchantAlliance
import com.example.sot_treasure_tracker.components.data.catalog_pages.OrderOfSouls
import com.example.sot_treasure_tracker.components.data.catalog_pages.Other
import com.example.sot_treasure_tracker.components.data.catalog_pages.ReapersBones
import com.example.sot_treasure_tracker.components.domain.models.TreasureCatalog

object Catalog : TreasureCatalog {
    override val catalog = listOf(
        GoldHoarders.page,
        MerchantAlliance.page,
        OrderOfSouls.page,
        AthenaFortune.page,
        ReapersBones.page,
        Other.page
    )
}
