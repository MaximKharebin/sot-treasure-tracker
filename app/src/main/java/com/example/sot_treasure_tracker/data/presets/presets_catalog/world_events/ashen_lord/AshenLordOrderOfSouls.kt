package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ashen_lord

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object AshenLordOrderOfSouls {
    val item = PresetItemDto(
        titleId = R.string.preset_ashen_lord_oos,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.oos_eye_of_souls,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.oos_corrupted_bounty_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.oos_dark_bounty_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.oos_ashen_winds_skull,
                quantity = 1
            ),
        )
    )
}