package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetCategoryDto
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort.SeaFortAthenaFortune
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort.SeaFortGoldHoarder
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort.SeaFortMerchantAlliance
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort.SeaFortOrderOfSouls
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort.SeaFortRegular

object SeaFortCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_sea_forts,
        items = listOf(
            SeaFortRegular.item,
            SeaFortGoldHoarder.item,
            SeaFortOrderOfSouls.item,
            SeaFortMerchantAlliance.item,
            SeaFortAthenaFortune.item,
        )
    )
}