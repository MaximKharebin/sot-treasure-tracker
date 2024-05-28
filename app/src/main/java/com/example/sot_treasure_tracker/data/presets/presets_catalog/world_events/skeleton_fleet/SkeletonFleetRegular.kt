package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fleet

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SkeletonFleetRegular {
    val item = PresetItemDto(
        titleId = R.string.preset_skeleton_fleet_regular,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.ritual_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ashen_key,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.ashen_chest,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.gh_skeleton_captains_chest,
                quantity = 8
            ),
            PresetRewardDto(
                treasureId = R.string.oos_skeleton_captains_skull,
                quantity = 6
            ),
            PresetRewardDto(
                treasureId = R.string.gh_marauders_chest,
                quantity = 6
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_exotic_silks,
                quantity = 6
            ),
            PresetRewardDto(
                treasureId = R.string.oos_disgraced_bounty_skull,
                quantity = 6
            ),
            PresetRewardDto(
                treasureId = R.string.emerald_gems,
                quantity = 6
            )
        )
    )
}