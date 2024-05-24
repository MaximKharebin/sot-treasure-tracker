package com.example.sot_treasure_tracker.presets.data.presets.world_events

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.presets.data.models.PresetCategoryDto

object CategoryWorldEvents {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_world_events,
        items = listOf(
            SeaFort.item,
            SeaFortGoldHoarder.item,
        )
    )
}