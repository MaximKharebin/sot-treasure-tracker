package com.example.sot_treasure_tracker.data.presets.presets_catalog.emegency

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetCategoryDto
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object EmergencyCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_emergency,
        items = listOf(
            PresetItemDto(
                titleId = R.string.preset_skeleton_ship,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_marauders_chest,
                        quantity = 2
                    ),
                    PresetRewardDto(
                        treasureId = R.string.ma_crate_of_exotic_silks,
                        quantity = 2
                    ),
                    PresetRewardDto(
                        treasureId = R.string.oos_disgraced_bounty_skull,
                        quantity = 2
                    ),
                    PresetRewardDto(
                        treasureId = R.string.emerald_gems,
                        quantity = 2
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_megalodon,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_marauders_chest,
                        quantity = 1
                    ),
                    PresetRewardDto(
                        treasureId = R.string.gh_skeleton_captains_chest,
                        quantity = 1
                    ),
                    PresetRewardDto(
                        treasureId = R.string.oos_hateful_bounty_skull,
                        quantity = 1
                    ),
                    PresetRewardDto(
                        treasureId = R.string.oos_skeleton_captains_skull,
                        quantity = 1
                    ),
                    PresetRewardDto(
                        treasureId = R.string.ma_crate_of_exotic_silks,
                        quantity = 1
                    ),
                    PresetRewardDto(
                        treasureId = R.string.ma_crate_of_ancient_bone_dust,
                        quantity = 1
                    ),
                    PresetRewardDto(
                        treasureId = R.string.emerald_gems,
                        quantity = 2
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_kraken,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_marauders_chest,
                        quantity = 2
                    ),
                    PresetRewardDto(
                        treasureId = R.string.oos_hateful_bounty_skull,
                        quantity = 2
                    ),
                    PresetRewardDto(
                        treasureId = R.string.ma_crate_of_exotic_silks,
                        quantity = 2
                    ),
                    PresetRewardDto(
                        treasureId = R.string.emerald_gems,
                        quantity = 2
                    )
                )
            )
        )
    )
}