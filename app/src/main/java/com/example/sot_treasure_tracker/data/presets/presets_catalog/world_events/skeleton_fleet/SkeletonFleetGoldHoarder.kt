package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fleet

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SkeletonFleetGoldHoarder {
    val item = PresetItemDto(
        titleId = R.string.preset_skeleton_fleet_gh,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.gh_sea_masters_chest,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.gh_sailors_chest,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.gh_jeweled_regular_artefacts,
                quantity = 4
            ),
            PresetRewardDto(
                treasureId = R.string.gh_glittering_hoarders_reliquary,
                quantity = 1
            )
        )
    )
}