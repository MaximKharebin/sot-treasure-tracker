package com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.presets.models.PresetCategoryDto
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fort.SkeletonFortAthenaFortune
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fort.SkeletonFortGoldHoarder
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fort.SkeletonFortMerchantAlliance
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fort.SkeletonFortOrderOfSouls
import com.example.sot_treasure_tracker.data.presets.presets_catalog.world_events.skeleton_fort.SkeletonFortRegular

object SkeletonFortCategory {
    val items = PresetCategoryDto(
        titleId = R.string.preset_title_skeleton_fort,
        items = listOf(
            SkeletonFortRegular.item,
            SkeletonFortGoldHoarder.item,
            SkeletonFortOrderOfSouls.item,
            SkeletonFortMerchantAlliance.item,
            SkeletonFortAthenaFortune.item,
        )
    )
}