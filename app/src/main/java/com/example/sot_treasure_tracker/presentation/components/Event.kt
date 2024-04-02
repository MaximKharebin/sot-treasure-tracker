package com.example.sot_treasure_tracker.presentation.components

import com.example.sot_treasure_tracker.components.SellFractions
import com.example.sot_treasure_tracker.data.models.TreasureItem

sealed class Event {

    data class IncrementTreasure(val treasureItem: TreasureItem, val pageIndex: Int) : Event()
    data class DecrementTreasure(val treasureItem: TreasureItem, val pageIndex: Int) : Event()
    data class CollapseControls(val state: ControlPanelState) : Event()
    data class ChangeEmissaryFraction(val sellFractions: SellFractions) : Event()
    data class ChangeEmissaryLevel(val level: Int) : Event()
}