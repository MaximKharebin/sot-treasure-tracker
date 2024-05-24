package com.example.sot_treasure_tracker.calculator.data.models

import com.example.sot_treasure_tracker.calculator.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.models.SellBuckets
import com.example.sot_treasure_tracker.calculator.domain.models.TreasureItem

data class TreasureItemDto(
    override val titleId: Int,
    override val belongsTo: SellBuckets,
    override val price: Price,
    override val emissaryValue: Int,
    override var quantity: Int = 0
) : TreasureItem
