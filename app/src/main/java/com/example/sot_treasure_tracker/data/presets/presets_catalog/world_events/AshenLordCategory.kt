package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetCategoryDto
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ashen_lord.AshenLordAthenaFortune
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ashen_lord.AshenLordGoldHoarder
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ashen_lord.AshenLordMerchantAlliance
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ashen_lord.AshenLordOrderOfSouls
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ashen_lord.AshenLordRegular

object AshenLordCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_ashen_lord,
        items = listOf(
            AshenLordRegular.item,
            AshenLordGoldHoarder.item,
            AshenLordOrderOfSouls.item,
            AshenLordMerchantAlliance.item,
            AshenLordAthenaFortune.item,
        )
    )
}