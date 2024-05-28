package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetCategoryDto
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ghost_armada.GhostArmadaAthenaFortune
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ghost_armada.GhostArmadaGoldHoarder
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ghost_armada.GhostArmadaMerchantAlliance
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ghost_armada.GhostArmadaOrderOfSouls
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.ghost_armada.GhostArmadaRegular
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury.SunkenTreasuryAthenaFortune
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury.SunkenTreasuryGoldHoarder
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury.SunkenTreasuryMerchantAlliance
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury.SunkenTreasuryOrderOfSouls
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sunken_treasury.SunkenTreasuryRegular

object GhostArmadaCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_ghost_armada,
        items = listOf(
            GhostArmadaRegular.item,
            GhostArmadaGoldHoarder.item,
            GhostArmadaOrderOfSouls.item,
            GhostArmadaMerchantAlliance.item,
            GhostArmadaAthenaFortune.item,
        )
    )
}