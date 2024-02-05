package com.example.sot_treasure_tracker.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.sot_treasure_tracker.domain.MultiplyRawValuesUseCase
import com.example.sot_treasure_tracker.domain.UpdateRawValuesUseCase
import com.example.sot_treasure_tracker.model.ControlPanelState
import com.example.sot_treasure_tracker.model.Emissary
import com.example.sot_treasure_tracker.model.Fraction
import com.example.sot_treasure_tracker.model.MultipliedRawValues
import com.example.sot_treasure_tracker.model.RawValues
import com.example.sot_treasure_tracker.model.StorageState
import com.example.sot_treasure_tracker.model.TreasureValue
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val updateRawValuesUseCase = UpdateRawValuesUseCase()
    private val multiplyRawValuesUseCase = MultiplyRawValuesUseCase()

    private val _storageState = MutableStateFlow(StorageState())
    val storageState = _storageState.asStateFlow()

    private val _controlPanelState = MutableStateFlow<ControlPanelState>(ControlPanelState.Opened)
    val controlPanelState = _controlPanelState.asStateFlow()

    private var RAW_VALUES = RawValues()
    private var MULTIPLIED_VALUES = MultipliedRawValues()


    fun onEvent(event: Event) {
        when (event) {
            is Event.DecrementTreasure -> {

            }

            is Event.IncrementTreasure -> {
                RAW_VALUES = updateRawValuesUseCase.execute(RAW_VALUES, event.treasure)

                updateMultipliedValues()
            }

            is Event.ChangeEmissaryFraction -> {
                _storageState.value = storageState.value.copy(
                    emissary = Emissary(
                        fraction = event.fraction,
                        level = storageState.value.emissary.level
                    )
                )

                updateMultipliedValues()
            }

            is Event.ChangeEmissaryLevel -> {
                _storageState.value = storageState.value.copy(
                    emissary = Emissary(
                        fraction = storageState.value.emissary.fraction,
                        level = event.level
                    )
                )
                updateMultipliedValues()
            }

            is Event.CollapseControls -> {
                _controlPanelState.value = event.state
            }
        }
    }

    private fun updateStorageStateTreasureValues(values: MultipliedRawValues) {
        val minGold = values.minGold.sum().toInt()
        val maxGold = values.maxGold.sum().toInt()
        val goldRange = minGold..maxGold
        val doubloons = values.doubloons.sum().toInt()
        val emissaryValue = values.emissaryValue.sum().toInt()

        _storageState.value = storageState.value.copy(
            treasureValue = TreasureValue(
                gold = goldRange,
                doubloons = doubloons,
                emissaryValue = emissaryValue
            )
        )
    }

    private fun updateMultipliedValues() {

        MULTIPLIED_VALUES = multiplyRawValuesUseCase
            .execute(RAW_VALUES, storageState.value.emissary)

        updateStorageStateTreasureValues(MULTIPLIED_VALUES)
    }
}