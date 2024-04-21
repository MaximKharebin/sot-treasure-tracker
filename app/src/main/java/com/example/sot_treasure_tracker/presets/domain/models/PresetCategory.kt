package com.example.sot_treasure_tracker.presets.domain.models

interface PresetCategory {
    val titleId: Int
    val items: List<PresetActivity>
}