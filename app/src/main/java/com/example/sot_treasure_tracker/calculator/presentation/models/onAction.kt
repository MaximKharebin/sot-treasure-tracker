package com.example.sot_treasure_tracker.calculator.presentation.models

import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.RepresentableFractions
import com.example.sot_treasure_tracker.components.domain.models.TreasureItem

sealed interface onAction {

    data class IncrementTreasure(val treasureItem: TreasureItem, val pageIndex: Int) : onAction
    data class DecrementTreasure(val treasureItem: TreasureItem, val pageIndex: Int) : onAction
    data class ClickControlPanelButton(val isOpen: Boolean) : onAction
    data class ChangeRepresentedFraction(val representableFractions: RepresentableFractions) : onAction
    data class ChangeEmissaryGrade(val grade: EmissaryGrades) : onAction

    data class ApplyPreset(val treasureIds: List<Int>, val treasureQuantities: List<Int>) : onAction
}