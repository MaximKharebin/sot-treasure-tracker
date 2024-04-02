package com.example.sot_treasure_tracker.presentation.components

import com.example.sot_treasure_tracker.components.SellFractions

data class EmissaryValues(
    val sellFractions: SellFractions = SellFractions.GOLD_HOARDERS,
    val level: Int = 0
)
