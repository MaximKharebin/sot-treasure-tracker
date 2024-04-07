package com.example.sot_treasure_tracker.tracker.presentation.model

import com.example.sot_treasure_tracker.tracker.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.tracker.domain.models.RepresentableFractions
import com.example.sot_treasure_tracker.tracker.domain.models.TreasureItem

sealed interface Event {

    data class IncrementTreasure(val treasureItem: TreasureItem, val pageIndex: Int) : Event
    data class DecrementTreasure(val treasureItem: TreasureItem, val pageIndex: Int) : Event
    data class ClickControlPanelButton(val isOpen: Boolean) : Event
    data class ChangeRepresentedFraction(val representableFractions: RepresentableFractions) : Event
    data class ChangeEmissaryGrade(val grade: EmissaryGrades) : Event
}