package com.example.sot_treasure_tracker.presets.domain.models

import com.example.sot_treasure_tracker.components.domain.models.CategoryItem

interface PresetItem : CategoryItem {
    val items: List<PresetReward>
}