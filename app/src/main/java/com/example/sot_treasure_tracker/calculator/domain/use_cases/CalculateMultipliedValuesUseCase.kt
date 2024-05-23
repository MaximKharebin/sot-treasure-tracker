package com.example.sot_treasure_tracker.calculator.domain.use_cases

import com.example.sot_treasure_tracker.calculator.domain.models.BaseValues
import com.example.sot_treasure_tracker.calculator.domain.models.Emissaries
import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.MultipliedValues
import com.example.sot_treasure_tracker.calculator.domain.models.SellBuckets
import javax.inject.Inject

class CalculateMultipliedValuesUseCase @Inject constructor() {

    fun execute(
        selectedEmissary: Emissaries,
        emissaryGrade: EmissaryGrades,
        baseValues: BaseValues
    ): MultipliedValues {

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

        for (fraction in SellBuckets.entries) {
            minGoldPerFraction[fraction.ordinal] = baseValues.minGold[fraction.ordinal]
            maxGoldPerFraction[fraction.ordinal] = baseValues.maxGold[fraction.ordinal]
            doubloonsPerFraction[fraction.ordinal] = baseValues.doubloons[fraction.ordinal]
            emissaryValuePerFraction[fraction.ordinal] =
                baseValues.emissaryValue[fraction.ordinal]
        }

        fun calculateRegularFraction() {
            minGoldPerFraction[selectedEmissary.ordinal] =
                baseValues.minGold[selectedEmissary.ordinal] * multiplier
            maxGoldPerFraction[selectedEmissary.ordinal] =
                baseValues.maxGold[selectedEmissary.ordinal] * multiplier
            doubloonsPerFraction[selectedEmissary.ordinal] =
                baseValues.doubloons[selectedEmissary.ordinal] * multiplier
            emissaryValuePerFraction[selectedEmissary.ordinal] =
                baseValues.emissaryValue[selectedEmissary.ordinal] * multiplier

            MultipliedValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )
        }

        return when (selectedEmissary) {
            Emissaries.GOLD_HOARDERS,
            Emissaries.MERCHANT_ALLIANCE,
            Emissaries.ORDER_OF_SOULS -> {

                minGoldPerFraction[selectedEmissary.ordinal] =
                    baseValues.minGold[selectedEmissary.ordinal] * multiplier
                maxGoldPerFraction[selectedEmissary.ordinal] =
                    baseValues.maxGold[selectedEmissary.ordinal] * multiplier
                doubloonsPerFraction[selectedEmissary.ordinal] =
                    baseValues.doubloons[selectedEmissary.ordinal] * multiplier
                emissaryValuePerFraction[selectedEmissary.ordinal] =
                    baseValues.emissaryValue[selectedEmissary.ordinal] * multiplier

                MultipliedValues(
                    minGold = minGoldPerFraction,
                    maxGold = maxGoldPerFraction,
                    doubloons = doubloonsPerFraction,
                    emissaryValue = emissaryValuePerFraction
                )
            }

            Emissaries.ATHENAS_FORTUNE -> {

                minGoldPerFraction[selectedEmissary.ordinal] =
                    baseValues.minGold[selectedEmissary.ordinal] * multiplier
                maxGoldPerFraction[selectedEmissary.ordinal] =
                    baseValues.maxGold[selectedEmissary.ordinal] * multiplier
                doubloonsPerFraction[selectedEmissary.ordinal] =
                    baseValues.doubloons[selectedEmissary.ordinal] * multiplier
                emissaryValuePerFraction[selectedEmissary.ordinal] =
                    baseValues.emissaryValue[selectedEmissary.ordinal] * multiplier

                return MultipliedValues(
                    minGold = minGoldPerFraction,
                    maxGold = maxGoldPerFraction,
                    doubloons = doubloonsPerFraction,
                    emissaryValue = emissaryValuePerFraction
                )
            }

            Emissaries.REAPERS_BONES -> {

                SellBuckets.entries.forEach { fractions ->
                    if (fractions != SellBuckets.UNIQUE) {
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

            Emissaries.GUILD -> {

                SellBuckets.entries.forEach { fractions ->
                    if (fractions != SellBuckets.REAPERS_BONES && fractions != SellBuckets.UNIQUE) {
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

            Emissaries.UNSELECTED -> MultipliedValues(
                minGold = baseValues.minGold,
                maxGold = baseValues.maxGold,
                doubloons = baseValues.doubloons,
                emissaryValue = baseValues.emissaryValue,
            )
        }
    }

}