package com.example.sot_treasure_tracker.presets.data

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.presets.data.presets.world_events.SeaFort
import com.example.sot_treasure_tracker.presets.data.models.PresetCategoryDto
import com.example.sot_treasure_tracker.presets.domain.models.PresetCatalog

object Presets : PresetCatalog {
    override val items = listOf(
        PresetCategoryDto(
            titleId = R.string.preset_title_world_events,
            items = listOf(
                SeaFort.item
            )
        )
    )
}