package com.example.sot_treasure_tracker.tracker.data.models

import com.example.sot_treasure_tracker.tracker.domain.models.Price
import com.example.sot_treasure_tracker.tracker.domain.models.SellFractions
import com.example.sot_treasure_tracker.tracker.domain.models.TreasureItem

data class TreasureItemDto(
    override val nameId: Int,
    override val belongsTo: SellFractions,
    override val price: Price,
    override val emissaryValue: Int,
    override var quantity: Int = 0
) : TreasureItem
