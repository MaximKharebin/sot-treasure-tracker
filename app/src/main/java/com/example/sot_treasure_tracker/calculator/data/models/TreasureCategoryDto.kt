package com.example.sot_treasure_tracker.calculator.data.models

import com.example.sot_treasure_tracker.components.domain.models.CatalogCategory

data class TreasureCategoryDto(
    override val titleId: Int,
    override val items: List<TreasureItemDto>
) : CatalogCategory
