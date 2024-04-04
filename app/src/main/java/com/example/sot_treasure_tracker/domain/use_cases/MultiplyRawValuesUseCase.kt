package com.example.sot_treasure_tracker.domain.use_cases

import android.util.Log
import com.example.sot_treasure_tracker.components.EmissaryGrades
import com.example.sot_treasure_tracker.components.RepresentableFractions
import com.example.sot_treasure_tracker.components.SellFractions
import com.example.sot_treasure_tracker.components.TrackerMultipliedValues
import com.example.sot_treasure_tracker.components.TrackerRawValues

class MultiplyRawValuesUseCase {

    fun execute(
        trackerRawValues: TrackerRawValues,
        representedFraction: RepresentableFractions,
        emissaryGrade: EmissaryGrades): TrackerMultipliedValues {

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

            val result = TrackerMultipliedValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )

            Log.d("TAGTAGTAG", "Calculating: ${result}")

            return result
        }

        fun calculateReapersFraction(multiplier: Float): TrackerMultipliedValues {
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

        fun calculateGuildFraction(multiplier: Float): TrackerMultipliedValues {
            SellFractions.entries.forEach { fractions ->
                if (fractions != SellFractions.REAPERS_BONES && fractions != SellFractions.UNIQUE) {
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

        return when (representedFraction) {
            RepresentableFractions.GOLD_HOARDERS,
            RepresentableFractions.MERCHANT_ALLIANCE,
            RepresentableFractions.ORDER_OF_SOULS,
            RepresentableFractions.ATHENAS_FORTUNE -> {
                 when (emissaryGrade) {
                    EmissaryGrades.FIRST_GRADE -> {
                        calculateRegularFraction(1f)
                    }

                    EmissaryGrades.SECOND_GRADE -> {
                        calculateRegularFraction(1.33f)
                    }

                    EmissaryGrades.THIRD_GRADE -> {
                        calculateRegularFraction(1.66f)
                    }

                    EmissaryGrades.FORTH_GRADE -> {
                        calculateRegularFraction(2f)
                    }

                    EmissaryGrades.FIFTH_GRADE -> {
                        calculateRegularFraction(2.5f)
                    }
                }
            }

            RepresentableFractions.REAPERS_BONES -> {
                when (emissaryGrade) {
                    EmissaryGrades.FIRST_GRADE -> {
                        calculateReapersFraction(1f)
                    }

                    EmissaryGrades.SECOND_GRADE -> {
                        calculateReapersFraction(1.33f)
                    }

                    EmissaryGrades.THIRD_GRADE -> {
                        calculateReapersFraction(1.66f)
                    }

                    EmissaryGrades.FORTH_GRADE -> {
                        calculateReapersFraction(2f)
                    }

                    EmissaryGrades.FIFTH_GRADE -> {
                        calculateReapersFraction(2.5f)
                    }
                }
            }

            RepresentableFractions.GUILD -> {
                when (emissaryGrade) {
                    EmissaryGrades.FIRST_GRADE -> {
                        calculateGuildFraction(1f)
                    }

                    EmissaryGrades.SECOND_GRADE -> {
                        calculateGuildFraction(1.15f)
                    }

                    EmissaryGrades.THIRD_GRADE -> {
                        calculateGuildFraction(1.30f)
                    }

                    EmissaryGrades.FORTH_GRADE -> {
                        calculateGuildFraction(1.45f)
                    }

                    EmissaryGrades.FIFTH_GRADE -> {
                        calculateGuildFraction(1.75f)
                    }
                }
            }
            RepresentableFractions.UNSELECTED,-> TrackerMultipliedValues(
                minGold = minGoldPerFraction,
                maxGold = maxGoldPerFraction,
                doubloons = doubloonsPerFraction,
                emissaryValue = emissaryValuePerFraction
            )
        }
    }
}