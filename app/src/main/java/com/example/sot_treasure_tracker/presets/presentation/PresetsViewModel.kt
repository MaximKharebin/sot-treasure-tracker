package com.example.sot_treasure_tracker.presets.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.use_cases.GetTreasureCatalogUseCase
import com.example.sot_treasure_tracker.presets.domain.models.PresetItem
import com.example.sot_treasure_tracker.presets.domain.models.PresetReward
import com.example.sot_treasure_tracker.presets.domain.use_cases.GetPresetsCatalogUseCase
import com.example.sot_treasure_tracker.presets.presentation.models.CostValues
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class PresetsViewModel @Inject constructor(
    getPresetsCatalogUseCase: GetPresetsCatalogUseCase,
    private val getTreasureCatalogUseCase: GetTreasureCatalogUseCase
) : ViewModel() {

    private val _presetCatalog = MutableStateFlow(getPresetsCatalogUseCase.execute())
    val presetCatalog = _presetCatalog.asStateFlow()

    private val _color = MutableStateFlow(0xFFFFFFFF)
    val color = _color.asStateFlow()

    private val treasureCatalog = getTreasureCatalogUseCase.execute()
    private val treasure: MutableList<PresetReward> = mutableListOf()

    fun setItemQuantity(presetItem: PresetItem, newQuantity: Int) {
        val quantityDifference = newQuantity - presetItem.quantity
        presetItem.quantity = newQuantity
        _color.value = Random.nextLong(0xFFFFFFFF)

        if (quantityDifference > 0)
            presetItem.items.forEach { treasure.add(it) }
        else {
            presetItem.items.forEach { treasure.remove(it) }
        }
    }

    fun getStoredTreasure() = treasure.toList()

    fun getPresetRewardCost(treasureList: List<PresetReward>): CostValues {

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
                                    is Price.Doubloons -> doubloonsAmount += treasureItem.price.doubloons
                                    is Price.GoldRange -> {
                                        minGoldAmount += treasureItem.price.gold.first
                                        maxGoldAmount += treasureItem.price.gold.last
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
}