package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetCategoryDto
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_shrine.SunkenShrineAthenaFortune
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_shrine.SunkenShrineGoldHoarder
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_shrine.SunkenShrineMerchantAlliance
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_shrine.SunkenShrineOrderOfSouls
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_shrine.SunkenShrineRegular

object SunkenShrineCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_sunken_shrine,
        items = listOf(
            SunkenShrineRegular.item,
            SunkenShrineGoldHoarder.item,
            SunkenShrineOrderOfSouls.item,
            SunkenShrineMerchantAlliance.item,
            SunkenShrineAthenaFortune.item,
        )
    )
}