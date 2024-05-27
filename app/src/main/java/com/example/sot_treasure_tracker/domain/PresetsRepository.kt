package com.example.sot_treasure_tracker.domain

import com.example.sot_treasure_tracker.data.presets.PresetsCatalogInstance

interface PresetsRepository {
    fun getPresetsCatalog(): PresetsCatalogInstance
}