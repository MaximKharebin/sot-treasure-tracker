package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fort

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SkeletonFortMerchantAlliance {
    val item = PresetItemDto(
        titleId = R.string.preset_skeleton_fort_ma,
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
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.rag_and_bone_crates,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ma_scrolls_of_shrouded_waters,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_immaculate_diamonds,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_exquisite_spices,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_rare_tea,
                quantity = 3
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            )
        )
    )
}