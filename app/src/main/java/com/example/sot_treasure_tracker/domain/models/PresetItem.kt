package com.example.sot_treasure_tracker.domain.models

interface PresetItem : CategoryItem {
    val items: List<PresetReward>
}