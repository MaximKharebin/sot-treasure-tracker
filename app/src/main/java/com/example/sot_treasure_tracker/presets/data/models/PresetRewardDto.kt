package com.example.sot_treasure_tracker.presets.data.models

import com.example.sot_treasure_tracker.presets.domain.models.PresetReward

data class PresetRewardDto(
    override val treasureId: Int,
    override val quantity: Int
) : PresetReward
