package com.example.sot_treasure_tracker.domain.use_cases

import com.example.sot_treasure_tracker.domain.models.BaseValues
import com.example.sot_treasure_tracker.domain.models.Emissary
import com.example.sot_treasure_tracker.domain.models.EmissaryGrade
import com.example.sot_treasure_tracker.domain.models.MultipliedValues
import com.example.sot_treasure_tracker.domain.models.SellBucket
import javax.inject.Inject

class CalculateMultipliedValuesUseCase @Inject constructor() {

    private val minGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
    private val maxGoldPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
    private val doubloonsPerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
    private val emissaryValuePerFraction = mutableListOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)

    fun execute(
        selectedEmissary: Emissary,
        emissaryGrade: EmissaryGrade,
        baseValues: BaseValues
    ): MultipliedValues {

        SellBucket.entries.forEach { emissary ->
            minGoldPerFraction[emissary.ordinal] = baseValues.minGold[emissary.ordinal]
            maxGoldPerFraction[emissary.ordinal] = baseValues.maxGold[emissary.ordinal]
            doubloonsPerFraction[emissary.ordinal] = baseValues.doubloons[emissary.ordinal]
            emissaryValuePerFraction[emissary.ordinal] = baseValues.emissaryValue[emissary.ordinal]
        }

        return when (selectedEmissary) {
            Emissary.GOLD_HOARDERS,
            Emissary.MERCHANT_ALLIANCE,
            Emissary.ORDER_OF_SOULS -> {

                val multiplier = when (emissaryGrade) {
                    EmissaryGrade.FIRST_GRADE -> FIRST_GRADE_MULTIPLIER
                    EmissaryGrade.SECOND_GRADE -> SECOND_GRADE_MULTIPLIER
                    EmissaryGrade.THIRD_GRADE -> THIRD_GRADE_MULTIPLIER
                    EmissaryGrade.FORTH_GRADE -> FORTH_GRADE_MULTIPLIER
                    EmissaryGrade.FIFTH_GRADE -> FIFTH_GRADE_MULTIPLIER
                }

                multiplyValuesPerEmissary(selectedEmissary, multiplier)
                multiplyValuesPerEmissary(SellBucket.SHARED, multiplier)

                MultipliedValues(
                    minGold = minGoldPerFraction,
                    maxGold = maxGoldPerFraction,
                    doubloons = doubloonsPerFraction,
                    emissaryValue = emissaryValuePerFraction
                )
            }

            Emissary.ATHENAS_FORTUNE -> {

                val multiplier = when (emissaryGrade) {
                    EmissaryGrade.FIRST_GRADE -> FIRST_GRADE_MULTIPLIER
                    EmissaryGrade.SECOND_GRADE -> SECOND_GRADE_MULTIPLIER
                    EmissaryGrade.THIRD_GRADE -> THIRD_GRADE_MULTIPLIER
                    EmissaryGrade.FORTH_GRADE -> FORTH_GRADE_MULTIPLIER
                    EmissaryGrade.FIFTH_GRADE -> FIFTH_GRADE_MULTIPLIER
                }

                multiplyValuesPerEmissary(selectedEmissary, multiplier)

                MultipliedValues(
                    minGold = minGoldPerFraction,
                    maxGold = maxGoldPerFraction,
                    doubloons = doubloonsPerFraction,
                    emissaryValue = emissaryValuePerFraction
                )
            }

            Emissary.REAPERS_BONES -> {

                val multiplier = when (emissaryGrade) {
                    EmissaryGrade.FIRST_GRADE -> FIRST_GRADE_MULTIPLIER
                    EmissaryGrade.SECOND_GRADE -> SECOND_GRADE_MULTIPLIER
                    EmissaryGrade.THIRD_GRADE -> THIRD_GRADE_MULTIPLIER
                    EmissaryGrade.FORTH_GRADE -> FORTH_GRADE_MULTIPLIER
                    EmissaryGrade.FIFTH_GRADE -> FIFTH_GRADE_MULTIPLIER
                }

                for (emissary in SellBucket.entries) {
                    if (emissary == SellBucket.UNIQUE) continue
                    multiplyValuesPerEmissary(emissary, multiplier)
                }

                MultipliedValues(
                    minGold = minGoldPerFraction,
                    maxGold = maxGoldPerFraction,
                    doubloons = doubloonsPerFraction,
                    emissaryValue = emissaryValuePerFraction
                )
            }

            Emissary.GUILD -> {

                val multiplier = when (emissaryGrade) {
                    EmissaryGrade.FIRST_GRADE -> FIRST_GRADE_GUILD_MULTIPLIER
                    EmissaryGrade.SECOND_GRADE -> SECOND_GRADE_GUILD_MULTIPLIER
                    EmissaryGrade.THIRD_GRADE -> THIRD_GRADE_GUILD_MULTIPLIER
                    EmissaryGrade.FORTH_GRADE -> FORTH_GRADE_GUILD_MULTIPLIER
                    EmissaryGrade.FIFTH_GRADE -> FIFTH_GRADE_GUILD_MULTIPLIER
                }

                for (emissary in SellBucket.entries) {
                    if (emissary == SellBucket.REAPERS_BONES || emissary == SellBucket.UNIQUE) continue
                    multiplyValuesPerEmissary(emissary, multiplier)
                }

                MultipliedValues(
                    minGold = minGoldPerFraction,
                    maxGold = maxGoldPerFraction,
                    doubloons = doubloonsPerFraction,
                    emissaryValue = emissaryValuePerFraction
                )
            }

            Emissary.UNSELECTED -> MultipliedValues(
                minGold = baseValues.minGold,
                maxGold = baseValues.maxGold,
                doubloons = baseValues.doubloons,
                emissaryValue = baseValues.emissaryValue,
            )
        }
    }

    private fun multiplyValuesPerEmissary(emissary: SellBucket, multiplier: Float) {
        minGoldPerFraction[emissary.ordinal] *= multiplier
        maxGoldPerFraction[emissary.ordinal] *= multiplier
        doubloonsPerFraction[emissary.ordinal] *= multiplier
        emissaryValuePerFraction[emissary.ordinal] *= multiplier
    }

    private fun multiplyValuesPerEmissary(emissary: Emissary, multiplier: Float) {
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