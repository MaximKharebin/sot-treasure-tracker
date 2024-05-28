package com.example.sot_treasure_tracker.data.treasure.models

import com.example.sot_treasure_tracker.domain.models.CatalogCategory

data class TreasureCategoryDto(
    override val titleId: Int,
    override val items: List<TreasureItemDto>
) : CatalogCategory
