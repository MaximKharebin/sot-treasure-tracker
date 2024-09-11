package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SunkenTreasuryMerchantAlliance {
    val item = PresetItemDto(
        titleId = R.string.preset_sunken_treasury_ma,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_immaculate_diamonds,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_exotic_silks,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_exquisite_spices,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            )
        )
    )
}