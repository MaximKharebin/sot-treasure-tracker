package com.example.sot_treasure_tracker.presets.domain.models

interface PresetActivity {
    val titleId: Int
    val quantity: Int
    val items: List<PresetReward>
}