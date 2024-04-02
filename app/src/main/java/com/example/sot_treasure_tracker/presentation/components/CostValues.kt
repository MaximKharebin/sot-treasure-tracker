package com.example.sot_treasure_tracker.presentation.components

data class CostValues(
    val gold: IntRange = 0..0,
    val doubloons: Int = 0,
    val emissaryValue: Int = 0
)

data class TrackerRawValues(
    val minGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val maxGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val doubloons: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val emissaryValue: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
)

data class TrackerMultipliedValues(
    val minGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val maxGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val doubloons: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val emissaryValue: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
)
