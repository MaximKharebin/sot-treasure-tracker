package com.example.sot_treasure_tracker.calculator.domain.models

data class MultipliedValues(
    val minGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val maxGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val doubloons: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val emissaryValue: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
)
