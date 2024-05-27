package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fort

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SkeletonFortOrderOfSouls {
    val item = PresetItemDto(
        titleId = R.string.preset_sea_fort_oos,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.oos_villainous_bounty_skull,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.oos_stronghold_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ashen_key,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ashen_chest,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.rag_and_bone_crates,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.oos_veiled_eye_of_souls,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.oos_corrupted_bounty_skull,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.oos_dark_bounty_skull,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.oos_hateful_bounty_skull,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            )
        )
    )
}