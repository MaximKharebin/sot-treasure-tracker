package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ashen_lord

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object AshenLordGoldHoarder {
    val item = PresetItemDto(
        titleId = R.string.preset_ashen_lord_gh,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.oos_ashen_winds_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.gh_sailors_chest,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_vestige_of_power,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.gh_hoarders_reliquary,
                quantity = 1
            )
        )
    )
}