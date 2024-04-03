package com.example.sot_treasure_tracker.presentation.tracker

import androidx.lifecycle.ViewModel
import com.example.sot_treasure_tracker.data.catalog.Catalog
import com.example.sot_treasure_tracker.domain.use_cases.DecrementRawValuesUseCase
import com.example.sot_treasure_tracker.domain.use_cases.MultiplyRawValuesUseCase
import com.example.sot_treasure_tracker.domain.use_cases.IncrementRawValuesUseCase
import com.example.sot_treasure_tracker.components.ControlPanelState
import com.example.sot_treasure_tracker.components.CostValues
import com.example.sot_treasure_tracker.components.EmissaryGrades
import com.example.sot_treasure_tracker.presentation.tracker.components.Event
import com.example.sot_treasure_tracker.components.RepresentableFractions
import com.example.sot_treasure_tracker.components.TrackerMultipliedValues
import com.example.sot_treasure_tracker.components.TrackerRawValues
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TrackerViewModel : ViewModel() {

    private val incrementRawValuesUseCase = IncrementRawValuesUseCase()
    private val decrementRawValuesUseCase = DecrementRawValuesUseCase()
    private val multiplyRawValuesUseCase = MultiplyRawValuesUseCase()


    private val _catalog = MutableStateFlow(Catalog)
    val catalog = _catalog.asStateFlow()

    private val _costValues = MutableStateFlow(CostValues())
    val costValues = _costValues.asStateFlow()

    private val _representedFraction = MutableStateFlow<RepresentableFractions?>(null)
    val representedFraction = _representedFraction.asStateFlow()

    private val _emissaryGrade = MutableStateFlow<EmissaryGrades?>(null)
    val emissaryGrade = _emissaryGrade.asStateFlow()

    private val _controlPanelState = MutableStateFlow<ControlPanelState>(ControlPanelState.Opened)
    val controlPanelState = _controlPanelState.asStateFlow()

    private var RAW_VALUES = TrackerRawValues()
    private var MULTIPLIED_VALUES = TrackerMultipliedValues()


    fun onEvent(event: Event) {
        when (event) {
            is Event.DecrementTreasure -> {
                RAW_VALUES = decrementRawValuesUseCase.execute(RAW_VALUES, event.treasureItem)
                event.treasureItem.quantity -= 1
                updateMultipliedValues()
            }

            is Event.IncrementTreasure -> {
                RAW_VALUES = incrementRawValuesUseCase.execute(RAW_VALUES, event.treasureItem)
                event.treasureItem.quantity += 1
                updateMultipliedValues()
            }

            is Event.ChangeRepresentedFraction -> {
                _representedFraction.value = event.representableFractions
                updateMultipliedValues()
            }

            is Event.ChangeEmissaryGrade -> {
                _emissaryGrade.value = event.grade
                updateMultipliedValues()
            }

            is Event.CollapseControls -> {
                _controlPanelState.value = event.state
            }
        }
    }


    private fun updateMultipliedValues() {
        MULTIPLIED_VALUES = multiplyRawValuesUseCase
            .execute(RAW_VALUES, representedFraction.value, emissaryGrade.value)

        updateStorageStateTreasureValues(MULTIPLIED_VALUES)
    }

    private fun updateStorageStateTreasureValues(values: TrackerMultipliedValues) {
        val minGold = values.minGold.sum().toInt()
        val maxGold = values.maxGold.sum().toInt()
        val goldRange = minGold..maxGold
        val doubloons = values.doubloons.sum().toInt()
        val emissaryValue = values.emissaryValue.sum().toInt()

        _costValues.value = costValues.value.copy(
            gold = goldRange,
            doubloons = doubloons,
            emissaryValue = emissaryValue
        )
    }
}