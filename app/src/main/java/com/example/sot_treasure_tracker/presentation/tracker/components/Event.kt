package com.example.sot_treasure_tracker.presentation.tracker.components

import com.example.sot_treasure_tracker.components.ControlPanelState
import com.example.sot_treasure_tracker.components.EmissaryGrades
import com.example.sot_treasure_tracker.components.RepresentableFractions
import com.example.sot_treasure_tracker.data.models.TreasureItem

sealed interface Event {

    data class IncrementTreasure(val treasureItem: TreasureItem, val pageIndex: Int) : Event
    data class DecrementTreasure(val treasureItem: TreasureItem, val pageIndex: Int) : Event
    data class CollapseControls(val state: ControlPanelState) : Event
    data class ChangeRepresentedFraction(val representableFractions: RepresentableFractions) : Event
    data class ChangeEmissaryGrade(val grade: EmissaryGrades) : Event
}