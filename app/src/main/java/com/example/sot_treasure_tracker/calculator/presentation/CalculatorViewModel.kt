package com.example.sot_treasure_tracker.calculator.presentation

import androidx.lifecycle.ViewModel
import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.Emissaries
import com.example.sot_treasure_tracker.calculator.domain.models.MultipliedValues
import com.example.sot_treasure_tracker.calculator.domain.models.BaseValues
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem
import com.example.sot_treasure_tracker.calculator.domain.use_cases.GetTreasureCatalogUseCase
import com.example.sot_treasure_tracker.calculator.domain.use_cases.CalculateBaseValuesUseCase
import com.example.sot_treasure_tracker.calculator.domain.use_cases.CalculateMultipliedValuesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    getTreasureCatalogUseCase: GetTreasureCatalogUseCase,
    private val calculateBaseValuesUseCase: CalculateBaseValuesUseCase,
    private val calculateMultipliedValuesUseCase: CalculateMultipliedValuesUseCase
) : ViewModel() {

    private val _catalog = MutableStateFlow(getTreasureCatalogUseCase.execute())
    val treasureCatalog = _catalog.asStateFlow()

    private val _minGoldAmount = MutableStateFlow(0)
    val minGoldAmount = _minGoldAmount.asStateFlow()

    private val _maxGoldAmount = MutableStateFlow(0)
    val maxGoldAmount = _maxGoldAmount.asStateFlow()

    private val _doubloonsAmount = MutableStateFlow(0)
    val doubloonsAmount = _doubloonsAmount.asStateFlow()

    private val _emissaryValueAmount = MutableStateFlow(0)
    val emissaryValueAmount = _emissaryValueAmount.asStateFlow()

    private val _selectedEmissary = MutableStateFlow(Emissaries.UNSELECTED)
    val selectedEmissary = _selectedEmissary.asStateFlow()

    private val _emissaryGrade = MutableStateFlow(EmissaryGrades.FIRST_GRADE)
    val emissaryGrade = _emissaryGrade.asStateFlow()


    private var baseValues = BaseValues()
    private var multipliedValues = MultipliedValues()

    fun setSelectedEmissary(emissary: Emissaries) {
        _selectedEmissary.value = emissary

        multipliedValues = calculateMultipliedValuesUseCase
            .execute(
                selectedEmissary = selectedEmissary.value,
                emissaryGrade = emissaryGrade.value,
                baseValues = baseValues
            )
        assignValues(multipliedValues)
    }

    fun setEmissaryGrade(grade: EmissaryGrades) {
        _emissaryGrade.value = grade

        multipliedValues = calculateMultipliedValuesUseCase
            .execute(
                selectedEmissary = selectedEmissary.value,
                emissaryGrade = emissaryGrade.value,
                baseValues = baseValues
            )
        assignValues(multipliedValues)
    }

    fun setTreasureItemQuantity(treasureItem: TreasureItem, newQuantity: Int) {
        val quantityDifference = newQuantity - treasureItem.quantity
        treasureItem.quantity = newQuantity

        baseValues = calculateBaseValuesUseCase
            .execute(
                baseValues = baseValues,
                treasureItem = treasureItem,
                quantityDifference = quantityDifference
            )

        multipliedValues = calculateMultipliedValuesUseCase
            .execute(
                selectedEmissary = selectedEmissary.value,
                emissaryGrade = emissaryGrade.value,
                baseValues = baseValues
            )

        assignValues(multipliedValues)
    }

    private fun assignValues(values: MultipliedValues) {
        _minGoldAmount.value = values.minGold.sum().toInt()
        _maxGoldAmount.value = values.maxGold.sum().toInt()
        _doubloonsAmount.value = values.doubloons.sum().toInt()
        _emissaryValueAmount.value = values.emissaryValue.sum().toInt()
    }

    /*private fun applyPreset(treasureIds: List<Int>, treasureQuantities: List<Int>) {
        treasureIds.forEach { treasureId ->

            val itemIndex = treasureIds.indexOf(treasureId)
            treasureCatalog.value.forEach { categories ->
                categories.forEach { category ->
                    category.items.forEach { treasureItem ->
                        if (treasureId == treasureItem.nameId) {
                            for (i in 1..treasureQuantities[itemIndex]) {
                                treasureItem.quantity += 1
                                baseValues = calculateBaseValuesUseCase.execute(
                                    baseValues,
                                    treasureItem
                                )

                            }
                        }
                    }
                }
            }

            multipliedValues = calculateMultipliedValues()
            assignValues(multipliedValues)
        }
    }*/
}