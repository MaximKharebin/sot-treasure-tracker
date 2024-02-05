package com.example.sot_treasure_tracker.domain

import com.example.sot_treasure_tracker.model.Emissary
import com.example.sot_treasure_tracker.model.Fraction
import com.example.sot_treasure_tracker.model.MultipliedRawValues
import com.example.sot_treasure_tracker.model.RawValues

class MultiplyRawValuesUseCase {

    fun execute(rawValues: RawValues, emissary: Emissary): MultipliedRawValues {

        val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)

        for (fraction in Fraction.entries) {
            minGoldPerFraction[fraction.ordinal] = rawValues.minGold[fraction.ordinal]
            maxGoldPerFraction[fraction.ordinal] = rawValues.maxGold[fraction.ordinal]
            doubloonsPerFraction[fraction.ordinal] = rawValues.doubloons[fraction.ordinal]
            emissaryValuePerFraction[fraction.ordinal] = rawValues.emissaryValue[fraction.ordinal]
        }

        fun calculateRegularFraction(multiplier: Float): MultipliedRawValues {
            minGoldPerFraction[emissary.fraction.ordinal] =
                rawValues.minGold[emissary.fraction.ordinal] * multiplier
            maxGoldPerFraction[emissary.fraction.ordinal] =
                rawValues.maxGold[emissary.fraction.ordinal] * multiplier
            doubloonsPerFraction[emissary.fraction.ordinal] =
                rawValues.doubloons[emissary.fraction.ordinal] * multiplier
            emissaryValuePerFraction[emissary.fraction.ordinal] =
                rawValues.emissaryValue[emissary.fraction.ordinal] * multiplier

            if (emissary.fraction != Fraction.ATHENAS_FORTUNE) {
                minGoldPerFraction[Fraction.SHARED.ordinal] =
                    rawValues.minGold[Fraction.SHARED.ordinal] * multiplier
                maxGoldPerFraction[Fraction.SHARED.ordinal] =
                    rawValues.maxGold[Fraction.SHARED.ordinal] * multiplier
                doubloonsPerFraction[Fraction.SHARED.ordinal] =
                    rawValues.doubloons[Fraction.SHARED.ordinal] * multiplier
                emissaryValuePerFraction[Fraction.SHARED.ordinal] =
                    rawValues.emissaryValue[Fraction.SHARED.ordinal] * multiplier
            }

            return MultipliedRawValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )
        }

        fun calculateReapersFraction(multiplier: Float): MultipliedRawValues {
            Fraction.entries.forEach { fractions ->
                if (fractions != Fraction.SHARED && fractions != Fraction.UNIQUE) {
                    minGoldPerFraction[fractions.ordinal] =
                        rawValues.minGold[fractions.ordinal] * multiplier
                    maxGoldPerFraction[fractions.ordinal] =
                        rawValues.maxGold[fractions.ordinal] * multiplier
                    doubloonsPerFraction[fractions.ordinal] =
                        rawValues.doubloons[fractions.ordinal] * multiplier
                    emissaryValuePerFraction[fractions.ordinal] =
                        rawValues.emissaryValue[fractions.ordinal] * multiplier
                }
            }

            return MultipliedRawValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )
        }

        return when (emissary.fraction) {
            Fraction.GOLD_HOARDERS,
            Fraction.MERCHANT_ALLIANCE,
            Fraction.ORDER_OF_SOULS,
            Fraction.ATHENAS_FORTUNE -> {
                when (emissary.level) {
                    0 -> {
                        calculateRegularFraction(1f)
                    }

                    1 -> {
                        calculateRegularFraction(1.33f)
                    }

                    2 -> {
                        calculateRegularFraction(1.66f)
                    }

                    3 -> {
                        calculateRegularFraction(2f)
                    }

                    4 -> {
                        calculateRegularFraction(2.5f)
                    }

                    else -> MultipliedRawValues(
                        minGold = minGoldPerFraction,
                        maxGold = maxGoldPerFraction,
                        doubloons = doubloonsPerFraction,
                        emissaryValue = emissaryValuePerFraction
                    )
                }
            }

            Fraction.REAPERS_BONES -> {
                when (emissary.level) {
                    0 -> {
                        calculateReapersFraction(1f)
                    }

                    1 -> {
                        calculateReapersFraction(1.33f)
                    }

                    2 -> {
                        calculateReapersFraction(1.66f)
                    }

                    3 -> {
                        calculateReapersFraction(2f)
                    }

                    4 -> {
                        calculateReapersFraction(2.5f)
                    }

                    else -> MultipliedRawValues(
                        minGold = minGoldPerFraction,
                        maxGold = maxGoldPerFraction,
                        doubloons = doubloonsPerFraction,
                        emissaryValue = emissaryValuePerFraction
                    )
                }
            }

            Fraction.UNIQUE -> MultipliedRawValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )

            Fraction.SHARED -> MultipliedRawValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )
        }
    }
}