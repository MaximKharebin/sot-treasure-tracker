package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_shrine

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SunkenShrineMerchantAlliance {
    val item = PresetItemDto(
        titleId = R.string.preset_sunken_shrine_ma,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_exotic_silks,
                quantity = 5
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_immaculate_diamonds,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            ),
        )
    )
}