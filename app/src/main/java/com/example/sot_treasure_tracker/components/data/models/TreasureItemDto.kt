package com.example.sot_treasure_tracker.components.data.models

import com.example.sot_treasure_tracker.components.domain.models.Price
import com.example.sot_treasure_tracker.calculator.domain.models.SellFractions
import com.example.sot_treasure_tracker.components.domain.models.TreasureItem

data class TreasureItemDto(
    override val nameId: Int,
    override val belongsTo: SellFractions,
    override val price: Price,
    override val emissaryValue: Int,
    override var quantity: Int = 0
) : TreasureItem
