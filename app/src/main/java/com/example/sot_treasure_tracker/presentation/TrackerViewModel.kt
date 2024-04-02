package com.example.sot_treasure_tracker.presentation

import androidx.lifecycle.ViewModel
import com.example.sot_treasure_tracker.data.models.Catalog
import com.example.sot_treasure_tracker.domain.use_cases.DecrementRawValuesUseCase
import com.example.sot_treasure_tracker.domain.use_cases.MultiplyRawValuesUseCase
import com.example.sot_treasure_tracker.domain.use_cases.IncrementRawValuesUseCase
import com.example.sot_treasure_tracker.presentation.components.ControlPanelState
import com.example.sot_treasure_tracker.presentation.components.CostValues
import com.example.sot_treasure_tracker.presentation.components.EmissaryValues
import com.example.sot_treasure_tracker.presentation.components.Event
import com.example.sot_treasure_tracker.presentation.components.TrackerMultipliedValues
import com.example.sot_treasure_tracker.presentation.components.TrackerRawValues
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

    private val _emissaryValues = MutableStateFlow(EmissaryValues())
    val emissaryValues = _emissaryValues.asStateFlow()

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

            is Event.ChangeEmissaryFraction -> {
                _emissaryValues.value = emissaryValues.value.copy(fraction = event.fraction)
                updateMultipliedValues()
            }

            is Event.ChangeEmissaryLevel -> {
                _emissaryValues.value = emissaryValues.value.copy(level = event.level)
                updateMultipliedValues()
            }

            is Event.CollapseControls -> {
                _controlPanelState.value = event.state
            }
        }
    }


    private fun updateMultipliedValues() {
        MULTIPLIED_VALUES = multiplyRawValuesUseCase
            .execute(RAW_VALUES, emissaryValues.value)

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