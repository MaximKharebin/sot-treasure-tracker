package com.example.sot_treasure_tracker.domain.use_cases

import com.example.sot_treasure_tracker.domain.models.Price
import com.example.sot_treasure_tracker.domain.models.TreasureItem
import com.example.sot_treasure_tracker.domain.models.BaseValues
import com.example.sot_treasure_tracker.domain.models.SellBuckets
import javax.inject.Inject

class CalculateBaseValuesUseCase @Inject constructor() {

    fun execute(
        baseValues: BaseValues,
        treasureItem: TreasureItem,
        quantityDifference: Int
    ): BaseValues {

        val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)

        SellBuckets.entries.forEach {
            minGoldPerFraction[it.ordinal] = baseValues.minGold[it.ordinal]
            maxGoldPerFraction[it.ordinal] = baseValues.maxGold[it.ordinal]
            doubloonsPerFraction[it.ordinal] = baseValues.doubloons[it.ordinal]
            emissaryValuePerFraction[it.ordinal] = baseValues.emissaryValue[it.ordinal]
        }

        val bucketIndex = treasureItem.belongsTo.ordinal
        emissaryValuePerFraction[bucketIndex] =
            emissaryValuePerFraction[bucketIndex] + treasureItem.emissaryValue * quantityDifference

        when (val treasurePrice = treasureItem.price) {
            is Price.GoldRange -> {
                minGoldPerFraction[bucketIndex] =
                    minGoldPerFraction[bucketIndex] + treasurePrice.gold.first * quantityDifference
                maxGoldPerFraction[bucketIndex] =
                    maxGoldPerFraction[bucketIndex] + treasurePrice.gold.last * quantityDifference
            }

            is Price.Doubloons -> {
                doubloonsPerFraction[bucketIndex] =
                    doubloonsPerFraction[bucketIndex] + treasurePrice.doubloons * quantityDifference
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