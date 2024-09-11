package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_shrine

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SunkenShrineAthenaFortune {
    val item = PresetItemDto(
        titleId = R.string.preset_sunken_shrine_af,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.skull_of_ancient_fortune,
                quantity = 4
            ),
            PresetRewardDto(
                treasureId = R.string.artifact_of_legendary_hunger,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.crate_of_legendary_voyages,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.jar_of_athenas_incense,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.chalice_of_ancient_fortune,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            ),
        )
    )
}