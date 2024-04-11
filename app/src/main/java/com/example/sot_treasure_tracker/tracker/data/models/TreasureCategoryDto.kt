package com.example.sot_treasure_tracker.calculator.data.models

import com.example.sot_treasure_tracker.calculator.domain.models.TreasureCategory

data class TreasureCategoryDto(
    override val titleId: Int,
    override val items: List<TreasureItemDto>
) : TreasureCategory
