package com.example.sot_treasure_tracker.components

sealed class Price {
    data class Gold(val gold: IntRange) : Price()
    data class Doubloons(val doubloons: Int) : Price()
}
