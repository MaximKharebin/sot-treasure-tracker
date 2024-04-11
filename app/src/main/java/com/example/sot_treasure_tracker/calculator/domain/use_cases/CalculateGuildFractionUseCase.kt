package com.example.sot_treasure_tracker.calculator.domain.use_cases

import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.MultipliedValues
import com.example.sot_treasure_tracker.calculator.domain.models.BaseValues
import com.example.sot_treasure_tracker.calculator.domain.models.SellFractions

class CalculateGuildFractionUseCase {

    fun execute(emissaryGrades: EmissaryGrades, baseValues: BaseValues): MultipliedValues {

        val multiplier = when (emissaryGrades) {
            EmissaryGrades.FIRST_GRADE -> 1.0f
            EmissaryGrades.SECOND_GRADE -> 1.15f
            EmissaryGrades.THIRD_GRADE -> 1.30f
            EmissaryGrades.FORTH_GRADE -> 1.45f
            EmissaryGrades.FIFTH_GRADE -> 1.75f
        }

        val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)

        for (fraction in SellFractions.entries) {
            minGoldPerFraction[fraction.ordinal] = baseValues.minGold[fraction.ordinal]
            maxGoldPerFraction[fraction.ordinal] = baseValues.maxGold[fraction.ordinal]
            doubloonsPerFraction[fraction.ordinal] = baseValues.doubloons[fraction.ordinal]
            emissaryValuePerFraction[fraction.ordinal] = baseValues.emissaryValue[fraction.ordinal]
        }

        SellFractions.entries.forEach { fractions ->
            if (fractions != SellFractions.REAPERS_BONES && fractions != SellFractions.UNIQUE) {
                minGoldPerFraction[fractions.ordinal] =
                    baseValues.minGold[fractions.ordinal] * multiplier
                maxGoldPerFraction[fractions.ordinal] =
                    baseValues.maxGold[fractions.ordinal] * multiplier
                doubloonsPerFraction[fractions.ordinal] =
                    baseValues.doubloons[fractions.ordinal] * multiplier
                emissaryValuePerFraction[fractions.ordinal] =
                    baseValues.emissaryValue[fractions.ordinal] * multiplier
            }
        }

        return MultipliedValues(
            minGold = minGoldPerFraction,
            maxGold = maxGoldPerFraction,
            doubloons = doubloonsPerFraction,
            emissaryValue = emissaryValuePerFraction
        )
    }
}