package com.example.sot_treasure_tracker.domain.use_cases

import com.example.sot_treasure_tracker.domain.models.BaseValues
import com.example.sot_treasure_tracker.domain.models.Emissaries
import com.example.sot_treasure_tracker.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.domain.models.MultipliedValues
import com.example.sot_treasure_tracker.domain.models.SellBuckets
import javax.inject.Inject

class CalculateMultipliedValuesUseCase @Inject constructor() {

    private val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
    private val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
    private val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
    private val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)

    fun execute(
        selectedEmissary: Emissaries,
        emissaryGrade: EmissaryGrades,
        baseValues: BaseValues
    ): MultipliedValues {

        SellBuckets.entries.forEach { emissary ->
            minGoldPerFraction[emissary.ordinal] = baseValues.minGold[emissary.ordinal]
            maxGoldPerFraction[emissary.ordinal] = baseValues.maxGold[emissary.ordinal]
            doubloonsPerFraction[emissary.ordinal] = baseValues.doubloons[emissary.ordinal]
            emissaryValuePerFraction[emissary.ordinal] = baseValues.emissaryValue[emissary.ordinal]
        }

        return when (selectedEmissary) {
            Emissaries.GOLD_HOARDERS,
            Emissaries.MERCHANT_ALLIANCE,
            Emissaries.ORDER_OF_SOULS -> {

                val multiplier = when (emissaryGrade) {
                    EmissaryGrades.FIRST_GRADE -> FIRST_GRADE_MULTIPLIER
                    EmissaryGrades.SECOND_GRADE -> SECOND_GRADE_MULTIPLIER
                    EmissaryGrades.THIRD_GRADE -> THIRD_GRADE_MULTIPLIER
                    EmissaryGrades.FORTH_GRADE -> FORTH_GRADE_MULTIPLIER
                    EmissaryGrades.FIFTH_GRADE -> FIFTH_GRADE_MULTIPLIER
                }

                multiplyValuesPerEmissary(selectedEmissary, multiplier)
                multiplyValuesPerEmissary(SellBuckets.SHARED, multiplier)

                MultipliedValues(
                    minGold = minGoldPerFraction,
                    maxGold = maxGoldPerFraction,
                    doubloons = doubloonsPerFraction,
                    emissaryValue = emissaryValuePerFraction
                )
            }

            Emissaries.ATHENAS_FORTUNE -> {

                val multiplier = when (emissaryGrade) {
                    EmissaryGrades.FIRST_GRADE -> FIRST_GRADE_MULTIPLIER
                    EmissaryGrades.SECOND_GRADE -> SECOND_GRADE_MULTIPLIER
                    EmissaryGrades.THIRD_GRADE -> THIRD_GRADE_MULTIPLIER
                    EmissaryGrades.FORTH_GRADE -> FORTH_GRADE_MULTIPLIER
                    EmissaryGrades.FIFTH_GRADE -> FIFTH_GRADE_MULTIPLIER
                }

                multiplyValuesPerEmissary(selectedEmissary, multiplier)

                MultipliedValues(
                    minGold = minGoldPerFraction,
                    maxGold = maxGoldPerFraction,
                    doubloons = doubloonsPerFraction,
                    emissaryValue = emissaryValuePerFraction
                )
            }

            Emissaries.REAPERS_BONES -> {

                val multiplier = when (emissaryGrade) {
                    EmissaryGrades.FIRST_GRADE -> FIRST_GRADE_MULTIPLIER
                    EmissaryGrades.SECOND_GRADE -> SECOND_GRADE_MULTIPLIER
                    EmissaryGrades.THIRD_GRADE -> THIRD_GRADE_MULTIPLIER
                    EmissaryGrades.FORTH_GRADE -> FORTH_GRADE_MULTIPLIER
                    EmissaryGrades.FIFTH_GRADE -> FIFTH_GRADE_MULTIPLIER
                }

                for (emissary in SellBuckets.entries) {
                    if (emissary == SellBuckets.UNIQUE) continue
                    multiplyValuesPerEmissary(emissary, multiplier)
                }

                MultipliedValues(
                    minGold = minGoldPerFraction,
                    maxGold = maxGoldPerFraction,
                    doubloons = doubloonsPerFraction,
                    emissaryValue = emissaryValuePerFraction
                )
            }

            Emissaries.GUILD -> {

                val multiplier = when (emissaryGrade) {
                    EmissaryGrades.FIRST_GRADE -> FIRST_GRADE_GUILD_MULTIPLIER
                    EmissaryGrades.SECOND_GRADE -> SECOND_GRADE_GUILD_MULTIPLIER
                    EmissaryGrades.THIRD_GRADE -> THIRD_GRADE_GUILD_MULTIPLIER
                    EmissaryGrades.FORTH_GRADE -> FORTH_GRADE_GUILD_MULTIPLIER
                    EmissaryGrades.FIFTH_GRADE -> FIFTH_GRADE_GUILD_MULTIPLIER
                }

                for (emissary in SellBuckets.entries) {
                    if (emissary == SellBuckets.REAPERS_BONES || emissary == SellBuckets.UNIQUE) continue
                    multiplyValuesPerEmissary(emissary, multiplier)
                }

                MultipliedValues(
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

    private fun multiplyValuesPerEmissary(emissary: SellBuckets, multiplier: Float) {
        minGoldPerFraction[emissary.ordinal] *= multiplier
        maxGoldPerFraction[emissary.ordinal] *= multiplier
        doubloonsPerFraction[emissary.ordinal] *= multiplier
        emissaryValuePerFraction[emissary.ordinal] *= multiplier
    }

    private fun multiplyValuesPerEmissary(emissary: Emissaries, multiplier: Float) {
        minGoldPerFraction[emissary.ordinal] *= multiplier
        maxGoldPerFraction[emissary.ordinal] *= multiplier
        doubloonsPerFraction[emissary.ordinal] *= multiplier
        emissaryValuePerFraction[emissary.ordinal] *= multiplier
    }
    companion object {
        const val FIRST_GRADE_MULTIPLIER = 1.0f
        const val SECOND_GRADE_MULTIPLIER = 1.33f
        const val THIRD_GRADE_MULTIPLIER = 1.66f
        const val FORTH_GRADE_MULTIPLIER = 2.0f
        const val FIFTH_GRADE_MULTIPLIER = 2.5f

        const val FIRST_GRADE_GUILD_MULTIPLIER = 1.0f
        const val SECOND_GRADE_GUILD_MULTIPLIER = 1.15f
        const val THIRD_GRADE_GUILD_MULTIPLIER = 1.30f
        const val FORTH_GRADE_GUILD_MULTIPLIER = 1.45f
        const val FIFTH_GRADE_GUILD_MULTIPLIER = 1.75f
    }
}