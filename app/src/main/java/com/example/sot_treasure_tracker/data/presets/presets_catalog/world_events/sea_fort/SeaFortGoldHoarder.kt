package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SeaFortGoldHoarder {
    val item = PresetItemDto(
        titleId = R.string.preset_sea_fort_gh,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.gh_sailors_chest,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_captains_chest,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_cradle_of_virtue,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.gh_vestige_of_power,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 2
            )
        )
    )
}