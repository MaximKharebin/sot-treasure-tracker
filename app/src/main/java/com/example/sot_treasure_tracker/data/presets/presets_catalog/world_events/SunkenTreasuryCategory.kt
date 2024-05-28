package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetCategoryDto
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury.SunkenTreasuryAthenaFortune
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury.SunkenTreasuryGoldHoarder
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury.SunkenTreasuryMerchantAlliance
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury.SunkenTreasuryOrderOfSouls
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury.SunkenTreasuryRegular

object SunkenTreasuryCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_sunken_treasury,
        items = listOf(
            SunkenTreasuryRegular.item,
            SunkenTreasuryGoldHoarder.item,
            SunkenTreasuryOrderOfSouls.item,
            SunkenTreasuryMerchantAlliance.item,
            SunkenTreasuryAthenaFortune.item,
        )
    )
}