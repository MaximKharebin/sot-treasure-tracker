package com.example.sot_treasure_tracker.util.domain.models

interface TreasureCategory {
    val titleId: Int
    val items: List<TreasureItem>
}