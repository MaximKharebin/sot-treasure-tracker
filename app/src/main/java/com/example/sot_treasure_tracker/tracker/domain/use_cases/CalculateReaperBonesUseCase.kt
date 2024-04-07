package com.example.sot_treasure_tracker.tracker.domain.use_cases

import com.example.sot_treasure_tracker.tracker.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.tracker.domain.models.TrackerMultipliedValues
import com.example.sot_treasure_tracker.tracker.domain.models.TrackerRawValues
import com.example.sot_treasure_tracker.tracker.domain.models.SellFractions

class CalculateReaperBonesUseCase {

    fun execute(emissaryGrades: EmissaryGrades, trackerRawValues: TrackerRawValues): TrackerMultipliedValues {

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
            minGoldPerFraction[fraction.ordinal] = trackerRawValues.minGold[fraction.ordinal]
            maxGoldPerFraction[fraction.ordinal] = trackerRawValues.maxGold[fraction.ordinal]
            doubloonsPerFraction[fraction.ordinal] = trackerRawValues.doubloons[fraction.ordinal]
            emissaryValuePerFraction[fraction.ordinal] = trackerRawValues.emissaryValue[fraction.ordinal]
        }

        SellFractions.entries.forEach { fractions ->
            if (fractions != SellFractions.UNIQUE) {
                minGoldPerFraction[fractions.ordinal] =
                    trackerRawValues.minGold[fractions.ordinal] * multiplier
                maxGoldPerFraction[fractions.ordinal] =
                    trackerRawValues.maxGold[fractions.ordinal] * multiplier
                doubloonsPerFraction[fractions.ordinal] =
                    trackerRawValues.doubloons[fractions.ordinal] * multiplier
                emissaryValuePerFraction[fractions.ordinal] =
                    trackerRawValues.emissaryValue[fractions.ordinal] * multiplier
            }
        }

        return TrackerMultipliedValues(
            minGold = minGoldPerFraction,
            maxGold = maxGoldPerFraction,
            doubloons = doubloonsPerFraction,
            emissaryValue = emissaryValuePerFraction
        )
    }
}