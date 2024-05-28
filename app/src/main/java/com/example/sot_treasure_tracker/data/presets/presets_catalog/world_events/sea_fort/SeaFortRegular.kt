package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object SeaFortRegular {
    val item = PresetItemDto(
        titleId = R.string.preset_sea_fort_regular,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.gh_chest_of_the_damned,
                quantity = 4
            ),
            PresetRewardDto(
                treasureId = R.string.oos_skull_of_the_damned,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.ma_ashes_of_the_damned,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.gh_captains_chest,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.oos_villainous_bounty_skull,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_exotic_silks,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.gh_gold_regular_artefacts,
                quantity = 4
            ),
            PresetRewardDto(
                treasureId = R.string.emerald_gems,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ma_special_resource_crates,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.oos_disgraced_bounty_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            )
        )
    )
}