package com.example.sot_treasure_tracker.data.model

sealed class Price {
    data class Gold(val price: IntRange) : Price()
    data class Doubloons(val price: Int) : Price()
}
