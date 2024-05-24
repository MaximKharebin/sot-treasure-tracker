package com.example.sot_treasure_tracker.presets.data.models

import com.example.sot_treasure_tracker.presets.domain.models.PresetItem

data class PresetItemDto(
    override val titleId: Int,
    override var quantity: Int = 0,
    override val items: List<PresetRewardDto>
) : PresetItem
