package com.example.sot_treasure_tracker.data.treasure.models

import com.example.sot_treasure_tracker.domain.models.Price
import com.example.sot_treasure_tracker.domain.models.SellBucket
import com.example.sot_treasure_tracker.domain.models.TreasureItem

data class TreasureItemDto(
    override val titleId: Int,
    override val belongsTo: SellBucket,
    override val price: Price,
    override val emissaryValue: Int,
    override var quantity: Int = 0
) : TreasureItem
