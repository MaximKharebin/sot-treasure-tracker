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

object AthenaFortuneVoyagesCategory {
    val items by lazy {
        PresetCategoryDto(
        titleId = R.string.preset_title_af_voyages,
        items = listOf(
            PresetItemDto(
                titleId = R.string.preset_af_veil,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.chest_of_legends,
                        quantity = 1
                    ),
                    PresetRewardDto(
                        treasureId = R.string.skull_of_athenas_blessing,
                        quantity = 3
                    ),
                    PresetRewardDto(
                        treasureId = R.string.jar_of_athenas_incense,
                        quantity = 3
                    ),
                    PresetRewardDto(
                        treasureId = R.string.artifact_of_legendary_hunger,
                        quantity = 3
                    ),
                    PresetRewardDto(
                        treasureId = R.string.crate_of_legendary_voyages,
                        quantity = 2
                    ),
                    PresetRewardDto(
                        treasureId = R.string.chalice_of_ancient_fortune,
                        quantity = 2
                    ),
                    PresetRewardDto(
                        treasureId = R.string.gh_chest_of_the_damned,
                        quantity = 4
                    ),
                    PresetRewardDto(
                        treasureId = R.string.oos_skull_of_the_damned,
                        quantity = 4
                    ),
                    PresetRewardDto(
                        treasureId = R.string.ma_ashes_of_the_damned,
                        quantity = 4
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_af_voyage_of_legends,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_af_ashen_voyage_of_legends,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_af_cursed_treasure,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_chest_of_sorrow,
                        quantity = 1
                    ),
                    PresetRewardDto(
                        treasureId = R.string.gh_chest_of_a_thousand_grogs,
                        quantity = 1
                    ),
                    PresetRewardDto(
                        treasureId = R.string.gh_chest_of_rage,
                        quantity = 1
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_af_skull_of_destiny,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.skull_of_destiny,
                        quantity = 1
                    )
                )
            )
        )
    )
    }
}