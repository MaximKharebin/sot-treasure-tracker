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

object OrderOfSoulsVoyagesCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_oos_voyages,
        items = listOf(
            PresetItemDto(
                titleId = R.string.preset_oos_skeleton_crew,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.oos_corrupted_bounty_skull,
                        quantity = 1
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_oos_skeleton_captains,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.oos_corrupted_bounty_skull,
                        quantity = 2
                    ),
                    PresetRewardDto(
                        treasureId = R.string.oos_dark_bounty_skull,
                        quantity = 1
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_oos_skeleton_lord,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_oos_ashen_skeleton_crew,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.oos_ashen_corrupted_bounty_skull,
                        quantity = 1
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_oos_ashen_skeleton_captains,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.oos_ashen_corrupted_bounty_skull,
                        quantity = 2
                    ),
                    PresetRewardDto(
                        treasureId = R.string.oos_ashen_dark_bounty_skull,
                        quantity = 1
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_oos_ashen_skeleton_lord,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_oos_armada,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_oos_ashen_armada,
                items = listOf(

                )
            )
        )

    )
}