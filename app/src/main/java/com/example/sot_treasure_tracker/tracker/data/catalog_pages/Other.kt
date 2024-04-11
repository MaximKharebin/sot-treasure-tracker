package com.example.sot_treasure_tracker.calculator.data.catalog_pages

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.data.models.TreasureCategoryDto
import com.example.sot_treasure_tracker.calculator.data.models.TreasureItemDto
import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.models.SellFractions
import com.example.sot_treasure_tracker.calculator.domain.models.TreasurePage

object Other : TreasurePage {
    override val page: List<TreasureCategoryDto> = listOf(
        TreasureCategoryDto(
            titleId = R.string.title_gem_stones,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ruby_gems,
                    price = Price.GoldRange(2000..2000),
                    emissaryValue = 6000,
                    belongsTo = SellFractions.SHARED
                ),
                TreasureItemDto(
                    nameId = R.string.emerald_gems,
                    price = Price.GoldRange(1500..1500),
                    emissaryValue = 4500,
                    belongsTo = SellFractions.SHARED
                ),
                TreasureItemDto(
                    nameId = R.string.sapphire_gems,
                    price = Price.GoldRange(1000..1000),
                    emissaryValue = 3000,
                    belongsTo = SellFractions.SHARED
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_treasure_chests,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.treasure_chest,
                    price = Price.GoldRange(250..520),
                    emissaryValue = 0,
                    belongsTo = SellFractions.SHARED
                ),
                TreasureItemDto(
                    nameId = R.string.coral_treasure_chest,
                    price = Price.GoldRange(375..780),
                    emissaryValue = 0,
                    belongsTo = SellFractions.SHARED
                ),
                TreasureItemDto(
                    nameId = R.string.ancient_chest,
                    price = Price.GoldRange(250..520),
                    emissaryValue = 0,
                    belongsTo = SellFractions.SHARED
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_breath_of_the_sea,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ruby_breath_of_the_sea,
                    price = Price.GoldRange(8000..8000),
                    emissaryValue = 24000,
                    belongsTo = SellFractions.SHARED
                ),
                TreasureItemDto(
                    nameId = R.string.emerald_breath_of_the_sea,
                    price = Price.GoldRange(6000..6000),
                    emissaryValue = 18000,
                    belongsTo = SellFractions.SHARED
                ),
                TreasureItemDto(
                    nameId = R.string.sapphire_breath_of_the_sea,
                    price = Price.GoldRange(4000..4000),
                    emissaryValue = 12000,
                    belongsTo = SellFractions.SHARED
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_bilge_rats,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.ashen_tomes,
                    price = Price.Doubloons(10),
                    emissaryValue = 1080,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.ashen_chest,
                    price = Price.Doubloons(5),
                    emissaryValue = 540,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.ashen_key,
                    price = Price.Doubloons(5),
                    emissaryValue = 900,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.ritual_skull,
                    price = Price.Doubloons(10),
                    emissaryValue = 750,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
                TreasureItemDto(
                    nameId = R.string.rag_and_bone_crates,
                    price = Price.Doubloons(5),
                    emissaryValue = 1080,
                    belongsTo = SellFractions.REAPERS_BONES
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_standalone_treasure,
            items = listOf(
                TreasureItemDto(
                    nameId = R.string.box_of_wondrous_secrets,
                    price = Price.GoldRange(25000..25000),
                    emissaryValue = 0,
                    belongsTo = SellFractions.UNIQUE
                ),
                TreasureItemDto(
                    nameId = R.string.skull_of_siren_song,
                    price = Price.GoldRange(50000..50000),
                    emissaryValue = 0,
                    belongsTo = SellFractions.UNIQUE
                )
            )
        )
    )
}
