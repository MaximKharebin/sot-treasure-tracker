package com.example.sot_treasure_tracker.model

import com.example.sot_treasure_tracker.data.TreasureStorage
import com.example.sot_treasure_tracker.data.model.TreasureCategory

data class StorageState(
    val storage: List<List<TreasureCategory>> = TreasureStorage.storage,
    val treasureValue: TreasureValue = TreasureValue(),
    val emissary: Emissary = Emissary()
)

data class TreasureValue(
    val gold: IntRange = 0..0,
    val doubloons: Int = 0,
    val emissaryValue: Int = 0
)

data class RawValues(
    val minGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val maxGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val doubloons: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val emissaryValue: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
)

data class MultipliedRawValues(
    val minGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val maxGold: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val doubloons: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f),
    val emissaryValue: MutableList<Float> = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
)

data class Emissary(
    val fraction: Fraction = Fraction.GOLD_HOARDERS,
    val level: Int = 0
)
