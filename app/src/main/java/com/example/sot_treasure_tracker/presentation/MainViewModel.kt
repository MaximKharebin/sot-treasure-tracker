package com.example.sot_treasure_tracker.presentation

import androidx.lifecycle.ViewModel
import com.example.sot_treasure_tracker.model.Fraction
import com.example.sot_treasure_tracker.model.ControlPanelState
import com.example.sot_treasure_tracker.model.ValueParams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val _treasuresTotalValue = MutableStateFlow(ValueParams(0..0, 0, 0))
    val treasuresTotalValue = _treasuresTotalValue.asStateFlow()

    private val _runningEmissary = MutableStateFlow(Fraction.GOLD_HOARDERS)
    val runningEmissary = _runningEmissary.asStateFlow()

    private val _emissaryLevel = MutableStateFlow(0)
    val emissaryLevel = _emissaryLevel.asStateFlow()

    private val _controlPanelState = MutableStateFlow<ControlPanelState>(ControlPanelState.Opened)
    val controlPanelState = _controlPanelState.asStateFlow()

    fun setRunningEmissary(fraction: Fraction) {
        _runningEmissary.value = fraction
    }

    fun setEmissaryLevel(level: Int) {
        _emissaryLevel.value = level
    }

    fun setControlPanelState(state: ControlPanelState) {
        _controlPanelState.value = state
    }
}