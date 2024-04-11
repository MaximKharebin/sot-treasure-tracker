package com.example.sot_treasure_tracker.calculator.data.catalog_pages

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.data.models.TreasureCategoryDto
import com.example.sot_treasure_tracker.calculator.data.models.TreasureItemDto
import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.models.SellFractions
import com.example.sot_treasure_tracker.calculator.domain.models.TreasurePage

object OrderOfSouls : TreasurePage {
    override val page: List<TreasureCategoryDto> = listOf(
        TreasureCategoryDto(
            titleId = R.string.title_regular_skulls,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.oos_wrathful_kings_bounty_skull,
                    price = Price.GoldRange(5100..5200),
                    emissaryValue = 15450,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_vicious_bounty_skull,
                    price = Price.GoldRange(3600..3650),
                    emissaryValue = 10875,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_corrupted_bounty_skull,
                    price = Price.GoldRange(2440..2460),
                    emissaryValue = 7350,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_vile_bounty_skull,
                    price = Price.GoldRange(1500..1550),
                    emissaryValue = 4575,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_dark_bounty_skull,
                    price = Price.GoldRange(1000..1050),
                    emissaryValue = 3075,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_villainous_bounty_skull,
                    price = Price.GoldRange(750..1450),
                    emissaryValue = 3240,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_hateful_bounty_skull,
                    price = Price.GoldRange(350..750),
                    emissaryValue = 1620,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_disgraced_bounty_skull,
                    price = Price.GoldRange(180..350),
                    emissaryValue = 810,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_foul_bounty_skull,
                    price = Price.GoldRange(90..180),
                    emissaryValue = 405,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_ashen_skulls,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.oos_ashen_wrathful_kings_bounty_skull,
                    price = Price.GoldRange(5800..5900),
                    emissaryValue = 17550,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_ashen_vicious_bounty_skull,
                    price = Price.GoldRange(4800..4850),
                    emissaryValue = 14475,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_ashen_corrupted_bounty_skull,
                    price = Price.GoldRange(3210..3230),
                    emissaryValue = 9660,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_ashen_vile_bounty_skull,
                    price = Price.GoldRange(1850..1900),
                    emissaryValue = 5625,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_ashen_dark_bounty_skull,
                    price = Price.GoldRange(1250..1260),
                    emissaryValue = 3750,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_ashen_villainous_bounty_skull,
                    price = Price.GoldRange(1450..2800),
                    emissaryValue = 6480,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_ashen_hateful_bounty_skull,
                    price = Price.GoldRange(750..1450),
                    emissaryValue = 3240,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_ashen_disgraced_bounty_skull,
                    price = Price.GoldRange(350..750),
                    emissaryValue = 1620,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_ashen_foul_bounty_skull,
                    price = Price.GoldRange(180..350),
                    emissaryValue = 810,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_coral_skulls,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.oos_coral_villainous_bounty_skull,
                    price = Price.GoldRange(1310..2540),
                    emissaryValue = 5670,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_coral_hateful_bounty_skull,
                    price = Price.GoldRange(610..1310),
                    emissaryValue = 2835,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_coral_disgraced_bounty_skull,
                    price = Price.GoldRange(315..615),
                    emissaryValue = 1419,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_coral_foul_bounty_skull,
                    price = Price.GoldRange(155..315),
                    emissaryValue = 711,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_encounter_and_quest_skulls,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.oos_ashen_winds_skull,
                    price = Price.GoldRange(
                        10000..10000
                    ),
                    emissaryValue = 15750,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_gold_hoarders_skull,
                    price = Price.GoldRange(
                        10000..10000
                    ),
                    emissaryValue = 0,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_stronghold_skull,
                    price = Price.GoldRange(1800..4200),
                    emissaryValue = 9720,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_captain_skull_of_the_damned,
                    price = Price.GoldRange(1700..2950),
                    emissaryValue = 7290,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_skull_of_the_damned,
                    price = Price.GoldRange(1050..1250),
                    emissaryValue = 3480,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_skeleton_captains_skull,
                    price = Price.GoldRange(850..2200),
                    emissaryValue = 4860,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_dark_relics,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.oos_hexing_skull,
                    price = Price.GoldRange(0..0),
                    emissaryValue = 0,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_enchantment_vessel,
                    price = Price.GoldRange(0..0),
                    emissaryValue = 0,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_evil_eye,
                    price = Price.GoldRange(0..0),
                    emissaryValue = 0,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_mutinous_effigy,
                    price = Price.GoldRange(0..0),
                    emissaryValue = 0,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_bewitching_doll,
                    price = Price.GoldRange(0..0),
                    emissaryValue = 0,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_raid_treasures,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.oos_all_seeing_eye_of_souls,
                    price = Price.GoldRange(15000..15000),
                    emissaryValue = 45000,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_veiled_eye_of_souls,
                    price = Price.GoldRange(10000..10000),
                    emissaryValue = 30000,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                ),
                TreasureItemDto(
                    nameId = R.string.oos_eye_of_souls,
                    price = Price.GoldRange(5000..5000),
                    emissaryValue = 15000,
                    belongsTo = SellFractions.ORDER_OF_SOULS
                )
            )
        )
    )
}
