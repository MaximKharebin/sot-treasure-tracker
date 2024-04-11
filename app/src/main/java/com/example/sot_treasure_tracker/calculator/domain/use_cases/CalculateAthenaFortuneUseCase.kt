package com.example.sot_treasure_tracker.calculator.domain.use_cases

import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.RepresentableFractions
import com.example.sot_treasure_tracker.calculator.domain.models.MultipliedValues
import com.example.sot_treasure_tracker.calculator.domain.models.BaseValues
import com.example.sot_treasure_tracker.calculator.domain.models.SellFractions

class CalculateAthenaFortuneUseCase {

    fun execute(
        emissaryGrades: EmissaryGrades,
        representedFraction: RepresentableFractions,
        baseValues: BaseValues
    ): MultipliedValues {

        val multiplier = when (emissaryGrades) {
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
            minGoldPerFraction[fraction.ordinal] = baseValues.minGold[fraction.ordinal]
            maxGoldPerFraction[fraction.ordinal] = baseValues.maxGold[fraction.ordinal]
            doubloonsPerFraction[fraction.ordinal] = baseValues.doubloons[fraction.ordinal]
            emissaryValuePerFraction[fraction.ordinal] =
                baseValues.emissaryValue[fraction.ordinal]
        }

        minGoldPerFraction[representedFraction.ordinal] =
            baseValues.minGold[representedFraction.ordinal] * multiplier
        maxGoldPerFraction[representedFraction.ordinal] =
            baseValues.maxGold[representedFraction.ordinal] * multiplier
        doubloonsPerFraction[representedFraction.ordinal] =
            baseValues.doubloons[representedFraction.ordinal] * multiplier
        emissaryValuePerFraction[representedFraction.ordinal] =
            baseValues.emissaryValue[representedFraction.ordinal] * multiplier

        if (representedFraction != RepresentableFractions.ATHENAS_FORTUNE) {
            minGoldPerFraction[SellFractions.SHARED.ordinal] =
                baseValues.minGold[SellFractions.SHARED.ordinal] * multiplier
            maxGoldPerFraction[SellFractions.SHARED.ordinal] =
                baseValues.maxGold[SellFractions.SHARED.ordinal] * multiplier
            doubloonsPerFraction[SellFractions.SHARED.ordinal] =
                baseValues.doubloons[SellFractions.SHARED.ordinal] * multiplier
            emissaryValuePerFraction[SellFractions.SHARED.ordinal] =
                baseValues.emissaryValue[SellFractions.SHARED.ordinal] * multiplier
        }

        return MultipliedValues(
            minGold = minGoldPerFraction,
            maxGold = maxGoldPerFraction,
            doubloons = doubloonsPerFraction,
            emissaryValue = emissaryValuePerFraction
        )
    }
}