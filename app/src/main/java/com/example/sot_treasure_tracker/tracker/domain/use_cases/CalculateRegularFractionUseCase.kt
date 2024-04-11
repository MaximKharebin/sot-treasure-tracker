package com.example.sot_treasure_tracker.calculator.domain.use_cases

import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.RepresentableFractions
import com.example.sot_treasure_tracker.calculator.domain.models.TrackerMultipliedValues
import com.example.sot_treasure_tracker.calculator.domain.models.TrackerRawValues
import com.example.sot_treasure_tracker.calculator.domain.models.SellFractions

class CalculateRegularFractionUseCase {

    fun execute(
        emissaryGrade: EmissaryGrades,
        representedFraction: RepresentableFractions,
        trackerRawValues: TrackerRawValues
    ): TrackerMultipliedValues {

        val multiplier = when (emissaryGrade) {
            EmissaryGrades.FIRST_GRADE -> 1.0f
            EmissaryGrades.SECOND_GRADE -> 1.33f
            EmissaryGrades.THIRD_GRADE -> 1.66f
            EmissaryGrades.FORTH_GRADE -> 2.0f
            EmissaryGrades.FIFTH_GRADE -> 2.5f
        }

        val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)

        for (fraction in SellFractions.entries) {
            minGoldPerFraction[fraction.ordinal] = trackerRawValues.minGold[fraction.ordinal]
            maxGoldPerFraction[fraction.ordinal] = trackerRawValues.maxGold[fraction.ordinal]
            doubloonsPerFraction[fraction.ordinal] = trackerRawValues.doubloons[fraction.ordinal]
            emissaryValuePerFraction[fraction.ordinal] = trackerRawValues.emissaryValue[fraction.ordinal]
        }

        minGoldPerFraction[representedFraction.ordinal] =
            trackerRawValues.minGold[representedFraction.ordinal] * multiplier
        maxGoldPerFraction[representedFraction.ordinal] =
            trackerRawValues.maxGold[representedFraction.ordinal] * multiplier
        doubloonsPerFraction[representedFraction.ordinal] =
            trackerRawValues.doubloons[representedFraction.ordinal] * multiplier
        emissaryValuePerFraction[representedFraction.ordinal] =
            trackerRawValues.emissaryValue[representedFraction.ordinal] * multiplier

        if (representedFraction != RepresentableFractions.ATHENAS_FORTUNE) {
            minGoldPerFraction[SellFractions.SHARED.ordinal] =
                trackerRawValues.minGold[SellFractions.SHARED.ordinal] * multiplier
            maxGoldPerFraction[SellFractions.SHARED.ordinal] =
                trackerRawValues.maxGold[SellFractions.SHARED.ordinal] * multiplier
            doubloonsPerFraction[SellFractions.SHARED.ordinal] =
                trackerRawValues.doubloons[SellFractions.SHARED.ordinal] * multiplier
            emissaryValuePerFraction[SellFractions.SHARED.ordinal] =
                trackerRawValues.emissaryValue[SellFractions.SHARED.ordinal] * multiplier
        }

        return TrackerMultipliedValues(
            minGold = minGoldPerFraction,
            maxGold = maxGoldPerFraction,
            doubloons = doubloonsPerFraction,
            emissaryValue = emissaryValuePerFraction
        )
    }
}