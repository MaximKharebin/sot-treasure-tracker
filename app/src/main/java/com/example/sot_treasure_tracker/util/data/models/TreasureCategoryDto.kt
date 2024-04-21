package com.example.sot_treasure_tracker.util.data.models

import com.example.sot_treasure_tracker.util.domain.models.TreasureCategory

data class TreasureCategoryDto(
    override val titleId: Int,
    override val items: List<TreasureItemDto>
) : TreasureCategory
