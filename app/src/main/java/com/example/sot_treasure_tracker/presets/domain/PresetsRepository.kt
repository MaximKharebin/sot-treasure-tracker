package com.example.sot_treasure_tracker.presets.domain

import com.example.sot_treasure_tracker.presets.data.PresetsCatalogInstance

interface PresetsRepository {
    fun getPresetsCatalog(): PresetsCatalogInstance
}