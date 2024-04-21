package com.example.sot_treasure_tracker.presets.data.presets.world_events

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.presets.data.models.PresetActivityDto
import com.example.sot_treasure_tracker.presets.data.models.PresetRewardDto

object SeaFort {
    val item = PresetActivityDto(
        titleId = R.string.preset_sea_fort,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.gh_chest_of_the_damned,
                quantity = 4
            ),
            PresetRewardDto(
                treasureId = R.string.ma_ashes_of_the_damned,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_exotic_silks,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.gh_gold_regular_artefacts,
                quantity = 2
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
                treasureId = R.string.oos_hateful_bounty_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ma_gunpowder_barrel,
                quantity = 4
            )
        )
    )
}