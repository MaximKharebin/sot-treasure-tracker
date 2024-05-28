package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetCategoryDto
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fleet.SkeletonFleetAthenaFortune
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fleet.SkeletonFleetGoldHoarder
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fleet.SkeletonFleetMerchantAlliance
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fleet.SkeletonFleetOrderOfSouls
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fleet.SkeletonFleetRegular

object SkeletonFleetCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_skeleton_fleet,
        items = listOf(
            SkeletonFleetRegular.item,
            SkeletonFleetGoldHoarder.item,
            SkeletonFleetOrderOfSouls.item,
            SkeletonFleetMerchantAlliance.item,
            SkeletonFleetAthenaFortune.item,
        )
    )
}