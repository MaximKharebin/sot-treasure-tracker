package com.example.sot_treasure_tracker.data.catalog

import com.example.sot_treasure_tracker.data.catalog.AthenaFortune
import com.example.sot_treasure_tracker.data.catalog.GoldHoarders
import com.example.sot_treasure_tracker.data.catalog.MerchantAlliance
import com.example.sot_treasure_tracker.data.catalog.OrderOfSouls
import com.example.sot_treasure_tracker.data.catalog.Other
import com.example.sot_treasure_tracker.data.catalog.ReapersBones

object Catalog {
    val items = listOf(
        GoldHoarders.treasure,
        MerchantAlliance.treasure,
        OrderOfSouls.treasure,
        AthenaFortune.treasure,
        ReapersBones.treasure,
        Other.treasure
    )
}
