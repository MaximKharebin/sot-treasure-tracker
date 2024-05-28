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

object GoldHoardersVoyagesCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_gh_voyages,
        items = listOf(
            PresetItemDto(
                titleId = R.string.preset_gh_pirate_map,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_sailors_chest,
                        quantity = 2
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_captain_map,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_sea_masters_chest,
                        quantity = 3
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_pirate_riddle,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_vestige_of_power,
                        quantity = 2
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_captain_riddle,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_cradle_of_virtue,
                        quantity = 2
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_ashen_pirate_map,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_ashen_sailors_chest,
                        quantity = 2
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_ashen_captain_map,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_ashen_sea_masters_chest,
                        quantity = 3
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_ashen_pirate_riddle,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_ashes_of_ruin,
                        quantity = 2
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_ashen_captain_riddle,
                items = listOf(
                    PresetRewardDto(
                        treasureId = R.string.gh_vessel_of_fire,
                        quantity = 2
                    )
                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_pirate_vault,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_captain_vault,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_ashen_pirate_vault,
                items = listOf(

                )
            ),
            PresetItemDto(
                titleId = R.string.preset_gh_ashen_captain_vault,
                items = listOf(

                )
            ),
        )

    )
}