package com.example.sot_treasure_tracker.presentation.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sot_treasure_tracker.domain.models.BaseValues
import com.example.sot_treasure_tracker.domain.models.Emissaries
import com.example.sot_treasure_tracker.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.domain.models.MultipliedValues
import com.example.sot_treasure_tracker.domain.models.SellBuckets
import com.example.sot_treasure_tracker.domain.models.TreasureItem
import com.example.sot_treasure_tracker.domain.use_cases.CalculateBaseValuesUseCase
import com.example.sot_treasure_tracker.domain.use_cases.CalculateMultipliedValuesUseCase
import com.example.sot_treasure_tracker.domain.use_cases.GetTreasureCatalogUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    getTreasureCatalogUseCase: GetTreasureCatalogUseCase,
    private val calculateBaseValuesUseCase: CalculateBaseValuesUseCase,
    private val calculateMultipliedValuesUseCase: CalculateMultipliedValuesUseCase
) : ViewModel() {

    private val _catalog = MutableStateFlow(getTreasureCatalogUseCase.execute())
    val catalog = _catalog.asStateFlow()

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

    private val _selectedTabIndex = MutableStateFlow(0)
    val selectedTabIndex = _selectedTabIndex.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()


    private var baseValues = BaseValues()
    private var multipliedValues = MultipliedValues()


    fun setSelectedTabIndex(index: Int) {
        _selectedTabIndex.value = index
    }

    fun setSelectedEmissary(emissary: Emissaries) {
        _selectedEmissary.value = emissary

        assignMultipliedValues()
        assignValues(multipliedValues)
    }

    fun setEmissaryGrade(grade: EmissaryGrades) {
        _emissaryGrade.value = grade

        assignMultipliedValues()
        assignValues(multipliedValues)
    }

    fun setItemQuantity(treasureItem: TreasureItem, newQuantity: Int) {
        val quantityDifference = newQuantity - treasureItem.quantity
        treasureItem.quantity += quantityDifference

        assignBaseValues(treasureItem, quantityDifference)
        assignMultipliedValues()
        assignValues(multipliedValues)
    }

    private fun assignBaseValues(treasureItem: TreasureItem, quantityDifference: Int) {
        baseValues = calculateBaseValuesUseCase
            .execute(
                baseValues = baseValues,
                treasureItem = treasureItem,
                quantityDifference = quantityDifference
            )
    }

    private fun assignMultipliedValues() {
        multipliedValues = calculateMultipliedValuesUseCase
            .execute(
                selectedEmissary = selectedEmissary.value,
                emissaryGrade = emissaryGrade.value,
                baseValues = baseValues
            )
    }

    private fun assignValues(values: MultipliedValues) {
        _minGoldAmount.value = values.minGold.sum().toInt()
        _maxGoldAmount.value = values.maxGold.sum().toInt()
        _doubloonsAmount.value = values.doubloons.sum().toInt()

        val emissaryValue = when (selectedEmissary.value) {
            Emissaries.GOLD_HOARDERS,
            Emissaries.ORDER_OF_SOULS,
            Emissaries.MERCHANT_ALLIANCE -> {
                val selectedEmissaryValue = values.emissaryValue[selectedEmissary.value.ordinal]
                val sharedEmissaryValue = values.emissaryValue[SellBuckets.SHARED.ordinal]
                selectedEmissaryValue + sharedEmissaryValue
            }

            Emissaries.ATHENAS_FORTUNE -> {
                values.emissaryValue[selectedEmissary.value.ordinal]
            }

            Emissaries.REAPERS_BONES -> {
                values.emissaryValue.sum()
            }

            Emissaries.GUILD -> {
                values.emissaryValue.sum() - values.emissaryValue[SellBuckets.REAPERS_BONES.ordinal]
            }

            Emissaries.UNSELECTED -> {
                0f
            }
        }

        _emissaryValueAmount.value = emissaryValue.toInt()
    }

    fun clearCalculator() {
        viewModelScope.launch(Dispatchers.Default) {
            _isLoading.value = true
            loopForEachItemInTreasureCatalog { item ->
                setItemQuantity(treasureItem = item, newQuantity = 0)
            }
            _isLoading.value = false
        }
    }


    fun applyPreset(treasureIds: List<Int>, treasureQuantities: List<Int>) {
        viewModelScope.launch(Dispatchers.Default) {
            _isLoading.value = true
            treasureIds.forEachIndexed { itemIndex, requiredId ->
                loopForEachItemInTreasureCatalog { item ->
                    val newQuantity = if (requiredId == item.titleId)
                        item.quantity + treasureQuantities[itemIndex]
                    else
                        item.quantity
                    setItemQuantity(treasureItem = item, newQuantity = newQuantity)
                }
            }
            _isLoading.value = false
        }
    }

    private fun loopForEachItemInTreasureCatalog(action: (TreasureItem) -> Unit) {
        catalog.value.forEach { catalogCategories ->
            catalogCategories.forEach { category ->
                category.items.forEach { item ->
                    action(item)
                }
            }
        }
    }
}