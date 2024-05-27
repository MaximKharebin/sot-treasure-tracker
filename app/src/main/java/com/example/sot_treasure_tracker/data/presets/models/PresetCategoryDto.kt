package com.example.sot_treasure_tracker.data.presets.models

import com.example.sot_treasure_tracker.domain.models.CatalogCategory

data class PresetCategoryDto(
    override val titleId: Int,
    override val items: List<PresetItemDto>
) : CatalogCategory
