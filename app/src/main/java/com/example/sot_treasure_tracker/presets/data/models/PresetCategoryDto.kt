package com.example.sot_treasure_tracker.presets.data.models

import com.example.sot_treasure_tracker.presets.domain.models.PresetCategory

data class PresetCategoryDto(
    override val titleId: Int,
    override val items: List<PresetActivityDto>
) : PresetCategory
