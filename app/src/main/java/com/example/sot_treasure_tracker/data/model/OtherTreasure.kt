package com.example.sot_treasure_tracker.data.model

import com.example.sot_treasure_tracker.data.Price

class OtherTreasure(
    override val treasureFraction: Int,
    override val name: Int,
    override val price: Price,
    override val emissaryValue: Int
) : AbstractTreasure()