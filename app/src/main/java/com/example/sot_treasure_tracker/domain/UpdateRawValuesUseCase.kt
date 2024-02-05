package com.example.sot_treasure_tracker.domain

import com.example.sot_treasure_tracker.data.model.Price
import com.example.sot_treasure_tracker.data.model.Treasure
import com.example.sot_treasure_tracker.model.Fraction
import com.example.sot_treasure_tracker.model.RawValues

class UpdateRawValuesUseCase {

    fun execute(rawValues: RawValues, treasure: Treasure): RawValues {

        val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)

        Fraction.entries.forEach { fraction ->
            if (treasure.canSellTo.contains(fraction)) {
                when (treasure.price) {
                    is Price.Gold -> {
                        minGoldPerFraction[fraction.ordinal] =
                            rawValues.minGold[fraction.ordinal] + treasure.price.gold.first
                        maxGoldPerFraction[fraction.ordinal] =
                            rawValues.maxGold[fraction.ordinal] + treasure.price.gold.last
                    }

                    is Price.Doubloons -> {
                        doubloonsPerFraction[fraction.ordinal] =
                            rawValues.doubloons[fraction.ordinal] + treasure.price.doubloons
                    }
                }
                emissaryValuePerFraction[fraction.ordinal] =
                    rawValues.emissaryValue[fraction.ordinal] + treasure.emissaryValue.toFloat()
            } else {
                minGoldPerFraction[fraction.ordinal] = rawValues.minGold[fraction.ordinal]
                maxGoldPerFraction[fraction.ordinal] = rawValues.maxGold[fraction.ordinal]
                doubloonsPerFraction[fraction.ordinal] = rawValues.doubloons[fraction.ordinal]
                emissaryValuePerFraction[fraction.ordinal] = rawValues.emissaryValue[fraction.ordinal]
            }
        }

        return RawValues(
            minGold = minGoldPerFraction,
            maxGold = maxGoldPerFraction,
            doubloons = doubloonsPerFraction,
            emissaryValue = emissaryValuePerFraction
        )
    }
}