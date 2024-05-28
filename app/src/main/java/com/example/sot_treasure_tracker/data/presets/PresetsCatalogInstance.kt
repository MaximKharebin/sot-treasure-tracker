package com.example.sot_treasure_tracker.data.presets

import com.example.sot_treasure_tracker.data.presets.presets_catalog.emegency.EmergencyCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.voyages.AthenaFortuneVoyagesCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.voyages.GoldHoardersVoyagesCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.voyages.MerchantAllianceVoyagesCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.voyages.OrderOfSoulsVoyagesCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.AshenLordCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.GhostArmadaCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.SeaFortCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.SkeletonFleetCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.SkeletonFortCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.SunkenShrineCategory
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.SunkenTreasuryCategory

object PresetsCatalogInstance {
    val catalog = listOf(
        EmergencyCategory.items,
        
        SeaFortCategory.items,
        SunkenShrineCategory.items,
        SunkenTreasuryCategory.items,
        AshenLordCategory.items,
        SkeletonFortCategory.items,
        SkeletonFleetCategory.items,
        GhostArmadaCategory.items,

        GoldHoardersVoyagesCategory.items,
        OrderOfSoulsVoyagesCategory.items,
        MerchantAllianceVoyagesCategory.items,
        AthenaFortuneVoyagesCategory.items
    )
}