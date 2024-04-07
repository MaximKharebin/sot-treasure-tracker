package com.example.sot_treasure_tracker.tracker.domain.models

data class TrackerMultipliedValues(
    val minGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val maxGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val doubloons: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val emissaryValue: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
)
