package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SeaFortAthenaFortune {
    val item = PresetItemDto(
        titleId = R.string.preset_sea_fort_af,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.crate_of_legendary_voyages,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.chalice_of_ancient_fortune,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.skull_of_ancient_fortune,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 2
            )
        )
    )
}