package com.example.sot_treasure_tracker.presets.data.models

import com.example.sot_treasure_tracker.presets.domain.models.PresetActivity

data class PresetActivityDto(
    override val titleId: Int,
    override val quantity: Int = 0,
    override val items: List<PresetRewardDto>
) : PresetActivity
