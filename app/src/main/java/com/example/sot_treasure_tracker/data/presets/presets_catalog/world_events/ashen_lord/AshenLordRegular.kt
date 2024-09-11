package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ashen_lord

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object AshenLordRegular {
    val item = PresetItemDto(
        titleId = R.string.preset_ashen_lord_regular,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.oos_ashen_winds_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.gh_chest_of_rage,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ritual_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.treasure_chest,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ashen_chest,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.gh_ashen_captains_chest,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.gh_ashen_marauders_chest,
                quantity = 2
            )
            ,PresetRewardDto(
                treasureId = R.string.gh_devils_remnant,
                quantity = 2
            )
            ,PresetRewardDto(
                treasureId = R.string.gh_brimstone_casket,
                quantity = 2
            )
            ,PresetRewardDto(
                treasureId = R.string.oos_ashen_villainous_bounty_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.oos_ashen_hateful_bounty_skull,
                quantity = 2
            ),
            PresetRewardDto(
                treasureId = R.string.oos_ashen_disgraced_bounty_skull,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_precious_gemstones,
                quantity = 1
            ),
            PresetRewardDto(
                treasureId = R.string.ma_crate_of_extraordinary_minerals,
                quantity = 2
            ),
        )
    )
}