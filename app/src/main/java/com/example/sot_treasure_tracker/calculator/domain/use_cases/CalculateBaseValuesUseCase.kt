package com.example.sot_treasure_tracker.calculator.domain.use_cases

import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem
import com.example.sot_treasure_tracker.calculator.domain.models.BaseValues
import com.example.sot_treasure_tracker.calculator.domain.models.SellBuckets
import javax.inject.Inject

class CalculateBaseValuesUseCase @Inject constructor() {

    fun execute(
        baseValues: BaseValues,
        treasureItem: TreasureItem,
        quantityDifference: Int
    ): BaseValues {

        val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)

        SellBuckets.entries.forEach { fraction ->
            if (treasureItem.belongsTo == fraction) {
                when (treasureItem.price) {
                    is Price.GoldRange -> {
                        minGoldPerFraction[fraction.ordinal] =
                            baseValues.minGold[fraction.ordinal] + (treasureItem.price as Price.GoldRange).gold.first * quantityDifference
                        maxGoldPerFraction[fraction.ordinal] =
                            baseValues.maxGold[fraction.ordinal] + (treasureItem.price as Price.GoldRange).gold.last * quantityDifference
                    }

                    is Price.Doubloons -> {
                        doubloonsPerFraction[fraction.ordinal] =
                            baseValues.doubloons[fraction.ordinal] + (treasureItem.price as Price.Doubloons).doubloons * quantityDifference
                    }
                }
                emissaryValuePerFraction[fraction.ordinal] =
                    baseValues.emissaryValue[fraction.ordinal] + treasureItem.emissaryValue.toFloat() * quantityDifference
            } else {
                minGoldPerFraction[fraction.ordinal] = baseValues.minGold[fraction.ordinal]
                maxGoldPerFraction[fraction.ordinal] = baseValues.maxGold[fraction.ordinal]
                doubloonsPerFraction[fraction.ordinal] = baseValues.doubloons[fraction.ordinal]
                emissaryValuePerFraction[fraction.ordinal] = baseValues.emissaryValue[fraction.ordinal]
            }
        }

        return BaseValues(
            minGold = minGoldPerFraction,
            maxGold = maxGoldPerFraction,
            doubloons = doubloonsPerFraction,
            emissaryValue = emissaryValuePerFraction
        )
    }
}