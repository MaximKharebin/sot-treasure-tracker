package com.example.sot_treasure_tracker.domain.models

sealed interface Price {
    data class GoldRange(val gold: IntRange) :
        Price
    data class Doubloons(val doubloons: Int) :
        Price
}
