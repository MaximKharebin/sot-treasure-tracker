package com.example.sot_treasure_tracker.presentation

import com.example.sot_treasure_tracker.data.model.Treasure
import com.example.sot_treasure_tracker.model.ControlPanelState
import com.example.sot_treasure_tracker.model.Fraction

sealed interface Event {

    data class IncrementTreasure(val treasure: Treasure, val pageIndex: Int) : Event
    data class DecrementTreasure(val treasure: Treasure, val pageIndex: Int) : Event
    data class CollapseControls(val state: ControlPanelState) : Event
    data class ChangeEmissaryFraction(val fraction: Fraction) : Event
    data class ChangeEmissaryLevel(val level: Int) : Event
}