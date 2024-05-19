package com.example.sot_treasure_tracker.calculator.domain.use_cases

import com.example.sot_treasure_tracker.components.domain.models.Price
import com.example.sot_treasure_tracker.components.domain.models.TreasureItem
import com.example.sot_treasure_tracker.calculator.domain.models.BaseValues
import com.example.sot_treasure_tracker.calculator.domain.models.SellFractions

class DecrementRawValuesUseCase {

    fun execute(baseValues: BaseValues, treasureItem: TreasureItem): BaseValues {

        val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)

        SellFractions.entries.forEach { fraction ->
            if (treasureItem.belongsTo == fraction) {
                when (treasureItem.price) {
                    is Price.GoldRange -> {
                        minGoldPerFraction[fraction.ordinal] =
                            baseValues.minGold[fraction.ordinal] - (treasureItem.price as Price.GoldRange).gold.first
                        maxGoldPerFraction[fraction.ordinal] =
                            baseValues.maxGold[fraction.ordinal] - (treasureItem.price as Price.GoldRange).gold.last
                    }

                    is Price.Doubloons -> {
                        doubloonsPerFraction[fraction.ordinal] =
                            baseValues.doubloons[fraction.ordinal] - (treasureItem.price as Price.Doubloons).doubloons
                    }
                }
                emissaryValuePerFraction[fraction.ordinal] =
                    baseValues.emissaryValue[fraction.ordinal] - treasureItem.emissaryValue.toFloat()
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