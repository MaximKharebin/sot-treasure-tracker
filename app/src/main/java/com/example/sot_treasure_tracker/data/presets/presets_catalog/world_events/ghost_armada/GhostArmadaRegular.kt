package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ghost_armada

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto

object GhostArmadaRegular {
    val item = PresetItemDto(
        titleId = R.string.preset_ghost_armada_regular,
        items = listOf(
            PresetRewardDto(
                treasureId = R.string.ma_ashes_of_the_damned,
                quantity = 14
            ),
            PresetRewardDto(
                treasureId = R.string.oos_skull_of_the_damned,
                quantity = 14
            ),
            PresetRewardDto(
                treasureId = R.string.gh_chest_of_the_damned,
                quantity = 14
            ),
            PresetRewardDto(
                treasureId = R.string.oos_captain_skull_of_the_damned,
                quantity = 1
            ),
        )
    )
}