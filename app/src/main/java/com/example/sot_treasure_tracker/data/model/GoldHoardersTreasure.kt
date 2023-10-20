package com.example.sot_treasure_tracker.data.model

import com.example.sot_treasure_tracker.Constants
import com.example.sot_treasure_tracker.data.Price

class GoldHoardersTreasure(
    override val name: Int,
    override val price: Price,
    override val emissaryValue: Int
) : AbstractTreasure() {
    override val treasureFraction: Int = Constants.FRACTION_GOLD_HOARDER
}