package com.example.sot_treasure_tracker.data.presets.models

import com.example.sot_treasure_tracker.domain.models.PresetItem

data class PresetItemDto(
    override val titleId: Int,
    override var quantity: Int = 0,
    override val items: List<PresetRewardDto>
) : PresetItem
