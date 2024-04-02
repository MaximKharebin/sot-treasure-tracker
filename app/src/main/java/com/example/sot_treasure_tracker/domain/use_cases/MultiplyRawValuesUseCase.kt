package com.example.sot_treasure_tracker.domain.use_cases

import com.example.sot_treasure_tracker.presentation.components.EmissaryValues
import com.example.sot_treasure_tracker.components.Fraction
import com.example.sot_treasure_tracker.presentation.components.TrackerMultipliedValues
import com.example.sot_treasure_tracker.presentation.components.TrackerRawValues

class MultiplyRawValuesUseCase {

    fun execute(trackerRawValues: TrackerRawValues, emissaryValues: EmissaryValues): TrackerMultipliedValues {

        val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)
        val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)

        for (fraction in Fraction.entries) {
            minGoldPerFraction[fraction.ordinal] = trackerRawValues.minGold[fraction.ordinal]
            maxGoldPerFraction[fraction.ordinal] = trackerRawValues.maxGold[fraction.ordinal]
            doubloonsPerFraction[fraction.ordinal] = trackerRawValues.doubloons[fraction.ordinal]
            emissaryValuePerFraction[fraction.ordinal] = trackerRawValues.emissaryValue[fraction.ordinal]
        }

        fun calculateRegularFraction(multiplier: Float): TrackerMultipliedValues {
            minGoldPerFraction[emissaryValues.fraction.ordinal] =
                trackerRawValues.minGold[emissaryValues.fraction.ordinal] * multiplier
            maxGoldPerFraction[emissaryValues.fraction.ordinal] =
                trackerRawValues.maxGold[emissaryValues.fraction.ordinal] * multiplier
            doubloonsPerFraction[emissaryValues.fraction.ordinal] =
                trackerRawValues.doubloons[emissaryValues.fraction.ordinal] * multiplier
            emissaryValuePerFraction[emissaryValues.fraction.ordinal] =
                trackerRawValues.emissaryValue[emissaryValues.fraction.ordinal] * multiplier

            if (emissaryValues.fraction != Fraction.ATHENAS_FORTUNE) {
                minGoldPerFraction[Fraction.SHARED.ordinal] =
                    trackerRawValues.minGold[Fraction.SHARED.ordinal] * multiplier
                maxGoldPerFraction[Fraction.SHARED.ordinal] =
                    trackerRawValues.maxGold[Fraction.SHARED.ordinal] * multiplier
                doubloonsPerFraction[Fraction.SHARED.ordinal] =
                    trackerRawValues.doubloons[Fraction.SHARED.ordinal] * multiplier
                emissaryValuePerFraction[Fraction.SHARED.ordinal] =
                    trackerRawValues.emissaryValue[Fraction.SHARED.ordinal] * multiplier
            }

            return TrackerMultipliedValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )
        }

        fun calculateReapersFraction(multiplier: Float): TrackerMultipliedValues {
            Fraction.entries.forEach { fractions ->
                if (fractions != Fraction.SHARED && fractions != Fraction.UNIQUE) {
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

        return when (emissaryValues.fraction) {
            Fraction.GOLD_HOARDERS,
            Fraction.MERCHANT_ALLIANCE,
            Fraction.ORDER_OF_SOULS,
            Fraction.ATHENAS_FORTUNE -> {
                when (emissaryValues.level) {
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

                    else -> TrackerMultipliedValues(
                        minGold = minGoldPerFraction,
                        maxGold = maxGoldPerFraction,
                        doubloons = doubloonsPerFraction,
                        emissaryValue = emissaryValuePerFraction
                    )
                }
            }

            Fraction.REAPERS_BONES -> {
                when (emissaryValues.level) {
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

                    else -> TrackerMultipliedValues(
                        minGold = minGoldPerFraction,
                        maxGold = maxGoldPerFraction,
                        doubloons = doubloonsPerFraction,
                        emissaryValue = emissaryValuePerFraction
                    )
                }
            }

            Fraction.UNIQUE -> TrackerMultipliedValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )

            Fraction.SHARED -> TrackerMultipliedValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )
        }
    }
}