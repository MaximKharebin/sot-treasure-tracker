package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fort

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SkeletonFortOfFortune {
    val item = PresetItemDto(
        titleId = R.string.preset_skeleton_fort_regular,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.chest_of_legends,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.keg_of_ancient_black_powder,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.crate_of_legendary_voyages,
                quantity =4
            ),
            PresetRewardDto(
                treasureId = R.string.gilded_relic_of_ancient_fortune,
                quantity = 5
            ),
            PresetRewardDto(
                treasureId = R.string.chalice_of_ancient_fortune,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.villainous_skull_of_ancient_fortune,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.skull_of_ancient_fortune,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.gh_stronghold_chest,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.oos_stronghold_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_ancient_bone_dust,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.ma_stronghold_gunpowder_barrel,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.emerald_gems,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_exotic_silks,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_rare_tea,
                quantity = 1
            )
        )
    )
}