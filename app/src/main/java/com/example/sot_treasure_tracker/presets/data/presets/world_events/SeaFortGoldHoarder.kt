package com.example.sot_treasure_tracker.presets.data.presets.world_events

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.presets.data.models.PresetActivityDto
import com.example.sot_treasure_tracker.presets.data.models.PresetRewardDto

object SeaFortGoldHoarder {
    val item = PresetActivityDto(
        titleId = R.string.preset_sea_fort,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.gh_captains_chest,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_sailors_chest,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_cradle_od_virture,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.gh_vestige_of_power,
                quantity = 1
            )
        )
    )
}