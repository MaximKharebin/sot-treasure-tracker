package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SunkenTreasuryAthenaFortune {
    val item = PresetItemDto(
        titleId = R.string.preset_sunken_treasury_af,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.gilded_relic_of_ancient_fortune,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.crate_of_legendary_voyages,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.artifact_of_legendary_hunger,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.legendary_fortune_keeper,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            )
        )
    )
}