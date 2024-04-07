package com.example.sot_treasure_tracker.tracker.presentation.model

import com.example.sot_treasure_tracker.tracker.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.tracker.domain.models.RepresentableFractions

data class UiState(
    val costValues: CostValues,
    val representedEmissary: RepresentableFractions,
    val emissaryGrade: EmissaryGrades,
    val isControlPanelOpen: Boolean,
    val isCatalogLoading: Boolean
)