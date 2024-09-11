package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_shrine

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SunkenShrineOrderOfSouls {
    val item = PresetItemDto(
        titleId = R.string.preset_sunken_shrine_oos,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.oos_corrupted_bounty_skull,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.oos_dark_bounty_skull,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.oos_villainous_bounty_skull,
                quantity = 6
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            )
        )
    )
}