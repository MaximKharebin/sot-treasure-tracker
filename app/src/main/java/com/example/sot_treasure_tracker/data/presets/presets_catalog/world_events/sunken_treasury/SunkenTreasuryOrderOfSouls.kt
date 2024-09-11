package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SunkenTreasuryOrderOfSouls {
    val item = PresetItemDto(
        titleId = R.string.preset_sunken_treasury_oos,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.oos_corrupted_bounty_skull,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.oos_dark_bounty_skull,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.oos_coral_villainous_bounty_skull,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.oos_coral_hateful_bounty_skull,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            )
        )
    )
}