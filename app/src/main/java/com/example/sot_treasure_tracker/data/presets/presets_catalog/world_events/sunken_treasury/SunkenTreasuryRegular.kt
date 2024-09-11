package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SunkenTreasuryRegular {
    val item = PresetItemDto(
        titleId = R.string.preset_sunken_treasury_regular,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.gh_chest_of_ancient_tributes,
                quantity = 1
            )
        )
    )
}