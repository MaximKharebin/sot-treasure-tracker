package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SunkenTreasuryGoldHoarder {
    val item = PresetItemDto(
        titleId = R.string.preset_sunken_treasury_gh,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.gh_sea_masters_chest,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_coral_captains_chest,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_cradle_of_virtue,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_peculiar_coral_relic,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            )
        )
    )
}