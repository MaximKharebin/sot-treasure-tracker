package com.example.sot_treasure_tracker.calculator.presentation.model

import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.RepresentableFractions

data class UiState(
    val costValues: CostValues,
    val representedEmissary: RepresentableFractions,
    val emissaryGrade: EmissaryGrades,
    val isControlPanelOpen: Boolean,
    val isCatalogLoading: Boolean
)