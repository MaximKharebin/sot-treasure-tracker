package com.example.sot_treasure_tracker.data.presets.models

import com.example.sot_treasure_tracker.domain.models.PresetReward

data class PresetRewardDto(
    override val treasureId: Int,
    override val quantity: Int
) : PresetReward
