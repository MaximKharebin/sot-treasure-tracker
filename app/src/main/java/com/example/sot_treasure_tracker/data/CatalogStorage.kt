package com.example.sot_treasure_tracker.data

import com.example.sot_treasure_tracker.data.presets.PresetsCatalogInstance
import com.example.sot_treasure_tracker.data.treasure.TreasureCatalogInstance

interface CatalogStorage {
    val treasureCatalog: TreasureCatalogInstance
    val presetCatalog: PresetsCatalogInstance
}