package com.example.sot_treasure_tracker.presets.data.models

import com.example.sot_treasure_tracker.presets.domain.models.PresetCatalog

data class PresetCatalogDto(
    override val items: List<PresetCategoryDto>
) : PresetCatalog
