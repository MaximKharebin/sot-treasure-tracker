package com.example.sot_treasure_tracker.calculator.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.RepresentableFractions
import com.example.sot_treasure_tracker.calculator.domain.models.MultipliedValues
import com.example.sot_treasure_tracker.calculator.domain.models.BaseValues
import com.example.sot_treasure_tracker.components.domain.models.TreasureCatalog
import com.example.sot_treasure_tracker.calculator.domain.use_cases.CalculateAthenaFortuneUseCase
import com.example.sot_treasure_tracker.calculator.domain.use_cases.CalculateGuildFractionUseCase
import com.example.sot_treasure_tracker.calculator.domain.use_cases.CalculateReaperBonesUseCase
import com.example.sot_treasure_tracker.calculator.domain.use_cases.CalculateRegularFractionUseCase
import com.example.sot_treasure_tracker.calculator.domain.use_cases.DecrementRawValuesUseCase
import com.example.sot_treasure_tracker.components.domain.use_cases.GetCatalogUseCase
import com.example.sot_treasure_tracker.calculator.domain.use_cases.CalculateBaseValuesUseCase
import com.example.sot_treasure_tracker.calculator.presentation.model.CostValues
import com.example.sot_treasure_tracker.calculator.presentation.model.Event
import com.example.sot_treasure_tracker.calculator.presentation.model.UiState
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

    private var baseValues = BaseValues()
    private var multipliedValues = MultipliedValues()

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
                baseValues = decrementRawValuesUseCase.execute(baseValues, event.treasureItem)
                event.treasureItem.quantity -= 1
                multiplyCostValues()
            }

            is Event.IncrementTreasure -> {
                baseValues = calculateBaseValuesUseCase.execute(baseValues, event.treasureItem)
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
        multipliedValues = when (uiState.value.representedEmissary) {
            RepresentableFractions.GOLD_HOARDERS,
            RepresentableFractions.MERCHANT_ALLIANCE,
            RepresentableFractions.ORDER_OF_SOULS -> calculateRegularFractionUseCase.execute(
                uiState.value.emissaryGrade,
                uiState.value.representedEmissary,
                baseValues
            )

            RepresentableFractions.ATHENAS_FORTUNE -> calculateAthenaFortuneUseCase.execute(
                uiState.value.emissaryGrade,
                uiState.value.representedEmissary,
                baseValues
            )

            RepresentableFractions.REAPERS_BONES -> calculateReaperBonesUseCase.execute(
                uiState.value.emissaryGrade,
                baseValues
            )

            RepresentableFractions.GUILD -> calculateGuildFractionUseCase.execute(
                uiState.value.emissaryGrade,
                baseValues
            )

            RepresentableFractions.UNSELECTED -> MultipliedValues(
                minGold = baseValues.minGold,
                maxGold = baseValues.maxGold,
                doubloons = baseValues.doubloons,
                emissaryValue = baseValues.emissaryValue,
            )
        }

        formatCostValues(multipliedValues)
    }

    private fun formatCostValues(values: MultipliedValues) {
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