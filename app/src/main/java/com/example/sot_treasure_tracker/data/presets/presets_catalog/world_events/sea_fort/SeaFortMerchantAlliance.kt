package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SeaFortMerchantAlliance {
    val item = PresetItemDto(
        titleId = R.string.preset_sea_fort_ma,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_immaculate_diamonds,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_fine_sugar,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            ),
        )
    )
}