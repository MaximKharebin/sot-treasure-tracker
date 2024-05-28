package com.example.sot_treasure_tracker.domain

import com.example.sot_treasure_tracker.data.presets.PresetsCatalogInstance
import com.example.sot_treasure_tracker.data.treasure.TreasureCatalogInstance

interface Repository {

    fun getTreasureCatalog(): TreasureCatalogInstance
    fun getPresetsCatalog(): PresetsCatalogInstance
}