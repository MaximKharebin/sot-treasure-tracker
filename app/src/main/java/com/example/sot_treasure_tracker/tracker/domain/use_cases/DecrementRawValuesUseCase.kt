package com.example.sot_treasure_tracker.tracker.domain.use_cases

import com.example.sot_treasure_tracker.tracker.domain.models.Price
import com.example.sot_treasure_tracker.tracker.domain.models.TreasureItem
import com.example.sot_treasure_tracker.tracker.domain.models.TrackerRawValues
import com.example.sot_treasure_tracker.tracker.domain.models.SellFractions

class DecrementRawValuesUseCase {

    fun execute(trackerRawValues: TrackerRawValues, treasureItem: TreasureItem): TrackerRawValues {

        val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)

        SellFractions.entries.forEach { fraction ->
            if (treasureItem.belongsTo == fraction) {
                when (treasureItem.price) {
                    is Price.GoldRange -> {
                        minGoldPerFraction[fraction.ordinal] =
                            trackerRawValues.minGold[fraction.ordinal] - (treasureItem.price as Price.GoldRange).gold.first
                        maxGoldPerFraction[fraction.ordinal] =
                            trackerRawValues.maxGold[fraction.ordinal] - (treasureItem.price as Price.GoldRange).gold.last
                    }

                    is Price.Doubloons -> {
                        doubloonsPerFraction[fraction.ordinal] =
                            trackerRawValues.doubloons[fraction.ordinal] - (treasureItem.price as Price.Doubloons).doubloons
                    }
                }
                emissaryValuePerFraction[fraction.ordinal] =
                    trackerRawValues.emissaryValue[fraction.ordinal] - treasureItem.emissaryValue.toFloat()
            } else {
                minGoldPerFraction[fraction.ordinal] = trackerRawValues.minGold[fraction.ordinal]
                maxGoldPerFraction[fraction.ordinal] = trackerRawValues.maxGold[fraction.ordinal]
                doubloonsPerFraction[fraction.ordinal] = trackerRawValues.doubloons[fraction.ordinal]
                emissaryValuePerFraction[fraction.ordinal] = trackerRawValues.emissaryValue[fraction.ordinal]
            }
        }

        return TrackerRawValues(
            minGold = minGoldPerFraction,
            maxGold = maxGoldPerFraction,
            doubloons = doubloonsPerFraction,
            emissaryValue = emissaryValuePerFraction
        )
    }
}