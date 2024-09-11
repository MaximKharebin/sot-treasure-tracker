package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_shrine

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SunkenShrineGoldHoarder {
    val item = PresetItemDto(
        titleId = R.string.preset_sunken_shrine_gh,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.gh_sea_masters_chest,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_vestige_of_power,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_coral_seafarers_chest,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.trident_of_dark_tides,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            )
        )
    )
}