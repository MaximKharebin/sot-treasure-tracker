package com.example.sot_treasure_tracker.domain.use_cases

import com.example.sot_treasure_tracker.presentation.components.EmissaryValues
import com.example.sot_treasure_tracker.components.SellFractions
import com.example.sot_treasure_tracker.presentation.components.TrackerMultipliedValues
import com.example.sot_treasure_tracker.presentation.components.TrackerRawValues

class MultiplyRawValuesUseCase {

    fun execute(trackerRawValues: TrackerRawValues, emissaryValues: EmissaryValues): TrackerMultipliedValues {

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

        fun calculateRegularFraction(multiplier: Float): TrackerMultipliedValues {
            minGoldPerFraction[emissaryValues.sellFractions.ordinal] =
                trackerRawValues.minGold[emissaryValues.sellFractions.ordinal] * multiplier
            maxGoldPerFraction[emissaryValues.sellFractions.ordinal] =
                trackerRawValues.maxGold[emissaryValues.sellFractions.ordinal] * multiplier
            doubloonsPerFraction[emissaryValues.sellFractions.ordinal] =
                trackerRawValues.doubloons[emissaryValues.sellFractions.ordinal] * multiplier
            emissaryValuePerFraction[emissaryValues.sellFractions.ordinal] =
                trackerRawValues.emissaryValue[emissaryValues.sellFractions.ordinal] * multiplier

            if (emissaryValues.sellFractions != SellFractions.ATHENAS_FORTUNE) {
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

        fun calculateReapersFraction(multiplier: Float): TrackerMultipliedValues {
            SellFractions.entries.forEach { fractions ->
                if (fractions != SellFractions.SHARED && fractions != SellFractions.UNIQUE) {
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

        return when (emissaryValues.sellFractions) {
            SellFractions.GOLD_HOARDERS,
            SellFractions.MERCHANT_ALLIANCE,
            SellFractions.ORDER_OF_SOULS,
            SellFractions.ATHENAS_FORTUNE -> {
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

            SellFractions.REAPERS_BONES -> {
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

            SellFractions.UNIQUE -> TrackerMultipliedValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )

            SellFractions.SHARED -> TrackerMultipliedValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )
        }
    }
}