package com.example.sot_treasure_tracker.tracker.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sot_treasure_tracker.tracker.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.tracker.domain.models.RepresentableFractions
import com.example.sot_treasure_tracker.tracker.domain.models.TrackerMultipliedValues
import com.example.sot_treasure_tracker.tracker.domain.models.TrackerRawValues
import com.example.sot_treasure_tracker.tracker.domain.models.TreasureCatalog
import com.example.sot_treasure_tracker.tracker.domain.use_cases.CalculateAthenaFortuneUseCase
import com.example.sot_treasure_tracker.tracker.domain.use_cases.CalculateGuildFractionUseCase
import com.example.sot_treasure_tracker.tracker.domain.use_cases.CalculateReaperBonesUseCase
import com.example.sot_treasure_tracker.tracker.domain.use_cases.CalculateRegularFractionUseCase
import com.example.sot_treasure_tracker.tracker.domain.use_cases.DecrementRawValuesUseCase
import com.example.sot_treasure_tracker.tracker.domain.use_cases.GetCatalogUseCase
import com.example.sot_treasure_tracker.tracker.domain.use_cases.CalculateBaseValuesUseCase
import com.example.sot_treasure_tracker.tracker.presentation.model.CostValues
import com.example.sot_treasure_tracker.tracker.presentation.model.Event
import com.example.sot_treasure_tracker.tracker.presentation.model.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TrackerViewModel : ViewModel() {

    private val getCatalogUseCase = GetCatalogUseCase()
    private val calculateBaseValuesUseCase = CalculateBaseValuesUseCase()
    private val decrementRawValuesUseCase = DecrementRawValuesUseCase()
    private val calculateRegularFractionUseCase = CalculateRegularFractionUseCase()
    private val calculateAthenaFortuneUseCase = CalculateAthenaFortuneUseCase()
    private val calculateReaperBonesUseCase = CalculateReaperBonesUseCase()
    private val calculateGuildFractionUseCase = CalculateGuildFractionUseCase()


    private val _catalog = MutableStateFlow<TreasureCatalog?>(null)
    val catalog = _catalog.asStateFlow()

    private val _uiState = MutableStateFlow(
        UiState(
            costValues = CostValues(),
            representedEmissary = RepresentableFractions.UNSELECTED,
            emissaryGrade = EmissaryGrades.FIRST_GRADE,
            isControlPanelOpen = true,
            isCatalogLoading = true
        )
    )
    val uiState = _uiState.asStateFlow()

    private var BASE_VALUES = TrackerRawValues()
    private var MULTIPLIED_VALUES = TrackerMultipliedValues()

    init {
        viewModelScope.launch {
            _uiState.update { it.copy(isCatalogLoading = true) }
            _catalog.value = getCatalogUseCase.execute()
            _uiState.update { it.copy(isCatalogLoading = false) }
        }
    }


    fun onEvent(event: Event) {
        when (event) {
            is Event.DecrementTreasure -> {
                BASE_VALUES = decrementRawValuesUseCase.execute(BASE_VALUES, event.treasureItem)
                event.treasureItem.quantity -= 1
                multiplyCostValues()
            }

            is Event.IncrementTreasure -> {
                BASE_VALUES = calculateBaseValuesUseCase.execute(BASE_VALUES, event.treasureItem)
                event.treasureItem.quantity += 1
                multiplyCostValues()
            }

            is Event.ChangeRepresentedFraction -> {
                _uiState.update {
                    it.copy(representedEmissary = event.representableFractions)
                }

                multiplyCostValues()
            }

            is Event.ChangeEmissaryGrade -> {
                _uiState.update {
                    it.copy(emissaryGrade = event.grade)
                }
                multiplyCostValues()
            }

            is Event.ClickControlPanelButton -> {
                _uiState.update {
                    it.copy(isControlPanelOpen = event.isOpen)
                }
            }
        }
    }


    private fun multiplyCostValues() {
        MULTIPLIED_VALUES = when (uiState.value.representedEmissary) {
            RepresentableFractions.GOLD_HOARDERS,
            RepresentableFractions.MERCHANT_ALLIANCE,
            RepresentableFractions.ORDER_OF_SOULS -> calculateRegularFractionUseCase.execute(
                uiState.value.emissaryGrade,
                uiState.value.representedEmissary,
                BASE_VALUES
            )

            RepresentableFractions.ATHENAS_FORTUNE -> calculateAthenaFortuneUseCase.execute(
                uiState.value.emissaryGrade,
                uiState.value.representedEmissary,
                BASE_VALUES
            )

            RepresentableFractions.REAPERS_BONES -> calculateReaperBonesUseCase.execute(
                uiState.value.emissaryGrade,
                BASE_VALUES
            )

            RepresentableFractions.GUILD -> calculateGuildFractionUseCase.execute(
                uiState.value.emissaryGrade,
                BASE_VALUES
            )

            RepresentableFractions.UNSELECTED -> TrackerMultipliedValues(
                minGold = BASE_VALUES.minGold,
                maxGold = BASE_VALUES.maxGold,
                doubloons = BASE_VALUES.doubloons,
                emissaryValue = BASE_VALUES.emissaryValue,
            )
        }

        formatCostValues(MULTIPLIED_VALUES)
    }

    private fun formatCostValues(values: TrackerMultipliedValues) {
        val minGold = values.minGold.sum().toInt()
        val maxGold = values.maxGold.sum().toInt()
        val goldRange = minGold..maxGold
        val doubloons = values.doubloons.sum().toInt()
        val emissaryValue = values.emissaryValue.sum().toInt()

        _uiState.update {
            it.copy(
                costValues = CostValues(
                    gold = goldRange,
                    doubloons = doubloons,
                    emissaryValue = emissaryValue
                )
            )
        }
    }
}