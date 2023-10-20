package com.example.sot_treasure_tracker.data.model

import com.example.sot_treasure_tracker.data.Price


abstract class AbstractTreasure {
    abstract val treasureFraction: Int
    abstract val name: Int
    abstract val price: Price
    abstract val emissaryValue: Int

    private var quantity: Int = 0

    fun getQuantity() = quantity

    fun incrementAmount(): Boolean {
        quantity++
        return true
    }

    fun decrementAmount(): Boolean {
        if (quantity <= 0) return false
        quantity--
        return true
    }
}