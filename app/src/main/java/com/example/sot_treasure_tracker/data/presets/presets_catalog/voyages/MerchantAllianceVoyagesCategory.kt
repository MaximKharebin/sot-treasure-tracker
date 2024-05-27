package com.example.sot_treasure_tracker.data.presets.presets_catalog.voyages

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetCategoryDto
import com.example.sot_treasure_tracker.data.presets.models.PresetItemDto
import com.example.sot_treasure_tracker.data.presets.models.PresetRewardDto
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort.SeaFortAthenaFortune
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort.SeaFortGoldHoarder
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort.SeaFortMerchantAlliance
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort.SeaFortOrderOfSouls
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.sea_fort.SeaFortRegular

object MerchantAllianceVoyagesCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_ma_voyages,
        items = listOf(
            PresetItemDto(
                titleId = R.string.preset_ma_founder_contract,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_executive_founder_contract,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_ma_founder_cargo,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_ma_executive_cargo,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_ma_ashen_founder_cargo,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_ma_ashen_executive_cargo,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_ma_lost_shipment,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_ma_ashen_lost_shipment,
                items = listOf(

                )
            )
        )

    )
}