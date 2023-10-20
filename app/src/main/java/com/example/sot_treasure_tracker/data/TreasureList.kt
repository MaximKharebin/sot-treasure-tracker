package com.example.sot_treasure_tracker.data

interface TreasureList<T> {
    val treasure: List<TreasureCategory<T>>
}