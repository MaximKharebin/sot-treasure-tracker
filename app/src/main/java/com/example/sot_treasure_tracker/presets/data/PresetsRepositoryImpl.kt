package com.example.sot_treasure_tracker.presets.data

import com.example.sot_treasure_tracker.presets.domain.PresetsRepository
import javax.inject.Inject

class PresetsRepositoryImpl @Inject constructor(
    private val presetsCatalog: PresetsCatalog
): PresetsRepository {

    fun getPresetsCatalog() = presetsCatalog.catalog
}