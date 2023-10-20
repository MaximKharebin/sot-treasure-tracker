package com.example.sot_treasure_tracker.data

data class TreasureCategory<T> (
    val categoryTitle: Int,
    val categoryItems: List<T>
)