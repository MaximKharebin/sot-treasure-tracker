package com.example.sot_treasure_tracker.tracker.domain.models

interface TreasureCategory {
    val titleId: Int
    val items: List<TreasureItem>
}