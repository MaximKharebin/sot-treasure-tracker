package com.example.sot_treasure_tracker.data.storage

import com.example.sot_treasure_tracker.Constants
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.Price
import com.example.sot_treasure_tracker.data.TreasureCategory
import com.example.sot_treasure_tracker.data.TreasureList
import com.example.sot_treasure_tracker.data.model.OtherTreasure

object OtherStorage : TreasureList<OtherTreasure> {
    override val treasure = listOf(
        TreasureCategory(
            categoryTitle = R.string.title_shared_treasure,
            categoryItems = listOf(
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_ANY,
                    name = R.string.sapphire_gems,
                    price = Price.Gold(1000..1000),
                    emissaryValue = 3000,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_ANY,
                    name = R.string.emerald_gems,
                    price = Price.Gold(1500..1500),
                    emissaryValue = 4500,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_ANY,
                    name = R.string.ruby_gems,
                    price = Price.Gold(2000..2000),
                    emissaryValue = 6000,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_ANY,
                    name = R.string.treasure_chest,
                    price = Price.Gold(250..520),
                    emissaryValue = 0,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_ANY,
                    name = R.string.coral_treasure_chest,
                    price = Price.Gold(375..780),
                    emissaryValue = 0,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_reapers_treasure,
            categoryItems = listOf(
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.reapers_bounty,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 10800,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.reapers_chest,
                    price = Price.Doubloons(25),
                    emissaryValue = 10800,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.humble_gift,
                    price = Price.Doubloons(5),
                    emissaryValue = 1080,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.generous_gift,
                    price = Price.Doubloons(10),
                    emissaryValue = 2160,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_broken_emissary_flags,
            categoryItems = listOf(
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.broken_emissary_flag_grade_1,
                    price = Price.Gold(1600..2400),
                    emissaryValue = 6000,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.broken_emissary_flag_grade_2,
                    price = Price.Gold(3500..4900),
                    emissaryValue = 12000,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.broken_emissary_flag_grade_3,
                    price = Price.Gold(5500..6500),
                    emissaryValue = 18000,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.broken_emissary_flag_grade_4,
                    price = Price.Gold(7600..8500),
                    emissaryValue = 24000,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.broken_emissary_flag_grade_5,
                    price = Price.Gold(9500..10500),
                    emissaryValue = 30000,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_captains_logbook,
            categoryItems = listOf(
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.noteworthy_captains_logbook,
                    price = Price.Gold(300..300),
                    emissaryValue = 0,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.accomplished_captains_logbook,
                    price = Price.Gold(2500..2500),
                    emissaryValue = 0,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.remarkable_captains_logbook,
                    price = Price.Gold(10000..10000),
                    emissaryValue = 0,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.extraordinary_captains_logbook,
                    price = Price.Gold(25000..25000),
                    emissaryValue = 0,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_bilge_rats,
            categoryItems = listOf(
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.ashen_tomes,
                    price = Price.Doubloons(10),
                    emissaryValue = 1080,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.ashen_chest,
                    price = Price.Doubloons(5),
                    emissaryValue = 540,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.ashen_key,
                    price = Price.Doubloons(5),
                    emissaryValue = 900,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.ritual_skull,
                    price = Price.Doubloons(10),
                    emissaryValue = 750,
                ),
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_REAPER_BONES,
                    name = R.string.rag_and_bone_crates,
                    price = Price.Doubloons(5),
                    emissaryValue = 1080,
                ),
            )
        ),

        TreasureCategory(
            categoryTitle = R.string.title_standalone_treasure,
            categoryItems = listOf(
                OtherTreasure(
                    treasureFraction = Constants.FRACTION_STANDALONE,
                    name = R.string.box_of_wondrous_secrets,
                    price = Price.Gold(25000..25000),
                    emissaryValue = 0,
                ),
            )
        ),
    )
}
