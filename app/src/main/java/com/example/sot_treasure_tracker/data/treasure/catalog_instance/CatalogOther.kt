package com.example.sot_treasure_tracker.data.treasure.catalog_instance

import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.treasure.models.TreasureCategoryDto
import com.example.sot_treasure_tracker.data.treasure.models.TreasureItemDto
import com.example.sot_treasure_tracker.domain.models.Price
import com.example.sot_treasure_tracker.domain.models.SellBucket

object CatalogOther {
    val treasure: List<TreasureCategoryDto> = listOf(
        TreasureCategoryDto(
            titleId = R.string.title_gem_stones,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.ruby_gems,
                    price = Price.GoldRange(2000..2000),
                    emissaryValue = 6000,
                    belongsTo = SellBucket.SHARED
                ),
                TreasureItemDto(
                    titleId = R.string.emerald_gems,
                    price = Price.GoldRange(1500..1500),
                    emissaryValue = 4500,
                    belongsTo = SellBucket.SHARED
                ),
                TreasureItemDto(
                    titleId = R.string.sapphire_gems,
                    price = Price.GoldRange(1000..1000),
                    emissaryValue = 3000,
                    belongsTo = SellBucket.SHARED
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_treasure_chests,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.treasure_chest,
                    price = Price.GoldRange(250..520),
                    emissaryValue = 0,
                    belongsTo = SellBucket.SHARED
                ),
                TreasureItemDto(
                    titleId = R.string.coral_treasure_chest,
                    price = Price.GoldRange(375..780),
                    emissaryValue = 0,
                    belongsTo = SellBucket.SHARED
                ),
                TreasureItemDto(
                    titleId = R.string.ancient_chest,
                    price = Price.GoldRange(250..520),
                    emissaryValue = 0,
                    belongsTo = SellBucket.SHARED
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_breath_of_the_sea,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.ruby_breath_of_the_sea,
                    price = Price.GoldRange(8000..8000),
                    emissaryValue = 24000,
                    belongsTo = SellBucket.SHARED
                ),
                TreasureItemDto(
                    titleId = R.string.emerald_breath_of_the_sea,
                    price = Price.GoldRange(6000..6000),
                    emissaryValue = 18000,
                    belongsTo = SellBucket.SHARED
                ),
                TreasureItemDto(
                    titleId = R.string.sapphire_breath_of_the_sea,
                    price = Price.GoldRange(4000..4000),
                    emissaryValue = 12000,
                    belongsTo = SellBucket.SHARED
                )
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_bilge_rats,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.ashen_tomes,
                    price = Price.Doubloons(10),
                    emissaryValue = 1080,
                    belongsTo = SellBucket.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.ashen_chest,
                    price = Price.Doubloons(5),
                    emissaryValue = 540,
                    belongsTo = SellBucket.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.ashen_key,
                    price = Price.Doubloons(5),
                    emissaryValue = 900,
                    belongsTo = SellBucket.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.ritual_skull,
                    price = Price.Doubloons(10),
                    emissaryValue = 750,
                    belongsTo = SellBucket.REAPERS_BONES
                ),
                TreasureItemDto(
                    titleId = R.string.rag_and_bone_crates,
                    price = Price.Doubloons(5),
                    emissaryValue = 1080,
                    belongsTo = SellBucket.REAPERS_BONES
                ),
            )
        ),

        TreasureCategoryDto(
            titleId = R.string.title_standalone_treasure,
            items = listOf(
                TreasureItemDto(
                    titleId = R.string.trident_of_dark_tides,
                    price = Price.GoldRange(250..250),
                    emissaryValue = 0,
                    belongsTo = SellBucket.SHARED
                ),
                TreasureItemDto(
                    titleId = R.string.box_of_wondrous_secrets,
                    price = Price.GoldRange(25000..25000),
                    emissaryValue = 0,
                    belongsTo = SellBucket.UNIQUE
                ),
                TreasureItemDto(
                    titleId = R.string.skull_of_siren_song,
                    price = Price.GoldRange(50000..50000),
                    emissaryValue = 0,
                    belongsTo = SellBucket.UNIQUE
                )
            )
        )
    )
}
