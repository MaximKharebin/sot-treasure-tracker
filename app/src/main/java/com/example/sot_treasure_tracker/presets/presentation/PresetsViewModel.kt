package com.example.sot_treasure_tracker.presets.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.components.domain.use_cases.GetTreasureCatalogUseCase
import com.example.sot_treasure_tracker.presets.domain.models.PresetItem
import com.example.sot_treasure_tracker.presets.domain.models.PresetReward
import com.example.sot_treasure_tracker.presets.domain.use_cases.GetPresetsCatalogUseCase
import com.example.sot_treasure_tracker.presets.presentation.models.CostValues
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PresetsViewModel @Inject constructor(
    getPresetsCatalogUseCase: GetPresetsCatalogUseCase,
    private val getTreasureCatalogUseCase: GetTreasureCatalogUseCase
) : ViewModel() {

    private val _presetCatalog = MutableStateFlow(getPresetsCatalogUseCase.execute())
    val presetCatalog = _presetCatalog.asStateFlow()

    private val _minGoldAmount = MutableStateFlow(0)
    val minGoldAmount = _minGoldAmount.asStateFlow()

    private val _maxGoldAmount = MutableStateFlow(0)
    val maxGoldAmount = _maxGoldAmount.asStateFlow()

    private val _doubloonsAmount = MutableStateFlow(0)
    val doubloonsAmount = _doubloonsAmount.asStateFlow()

    private val _storedTreasureIds = MutableStateFlow<List<Int>>(listOf())
    val storedTreasureIds = _storedTreasureIds.asStateFlow()

    private val _storedTreasureQuantities = MutableStateFlow<List<Int>>(listOf())
    val storedTreasureQuantities = _storedTreasureQuantities.asStateFlow()


    private val treasureCatalog = getTreasureCatalogUseCase.execute()
    private val treasure: MutableList<PresetReward> = mutableListOf()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            _presetCatalog.value.forEach { catalogCategories ->
                catalogCategories.items.forEach { category ->
                    category.quantity = 0
                }
            }
        }
    }

    fun setItemQuantity(presetItem: PresetItem, newQuantity: Int) {
        val quantityDifference = newQuantity - presetItem.quantity
        presetItem.quantity = newQuantity

        if (quantityDifference > 0)
            presetItem.items.forEach { treasure.add(it) }
        else
            presetItem.items.forEach { treasure.remove(it) }

        assignValues(getPresetRewardCost(presetItem.items, quantityDifference))
        mapStoredTreasureList()
    }

    private fun mapStoredTreasureList() {
        _storedTreasureIds.value = treasure.map { it.treasureId }
        _storedTreasureQuantities.value = treasure.map { it.quantity }
    }

    fun getPresetRewardCost(
        treasureList: List<PresetReward>,
        quantityDifference: Int = 1,
    ): CostValues {

        val itemIds = treasureList.map { it.treasureId }
        val itemQuantities = treasureList.map { it.quantity }

        var minGoldAmount = 0
        var maxGoldAmount = 0
        var doubloonsAmount = 0

        itemIds.forEach { treasureId ->
            val itemIndex = itemIds.indexOf(treasureId)
            treasureCatalog.forEach { catalog ->
                catalog.forEach { category ->
                    category.items.forEach { treasureItem ->
                        if (treasureId == treasureItem.titleId) {
                            for (i in 1..itemQuantities[itemIndex]) {
                                when (treasureItem.price) {
                                    is Price.Doubloons -> doubloonsAmount += treasureItem.price.doubloons * quantityDifference
                                    is Price.GoldRange -> {
                                        minGoldAmount += treasureItem.price.gold.first * quantityDifference
                                        maxGoldAmount += treasureItem.price.gold.last * quantityDifference
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }

        return CostValues(
            minGoldAmount = minGoldAmount,
            maxGoldAmount = maxGoldAmount,
            doubloonsAmount = doubloonsAmount
        )
    }

    private fun assignValues(values: CostValues) {
        _minGoldAmount.value += values.minGoldAmount
        _maxGoldAmount.value += values.maxGoldAmount
        _doubloonsAmount.value += values.doubloonsAmount
    }
}