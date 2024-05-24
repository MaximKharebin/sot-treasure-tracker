package com.example.sot_treasure_tracker.presets.data.models

import com.example.sot_treasure_tracker.components.domain.models.CatalogCategory

data class PresetCategoryDto(
    override val titleId: Int,
    override val items: List<PresetItemDto>
) : CatalogCategory
