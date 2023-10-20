package com.example.sot_treasure_tracker.presentation

import com.example.sot_treasure_tracker.data.model.Treasure

interface TreasureClickListener {

    fun incrementTreasure(treasure: Treasure, pageIndex: Int)

    fun decrementTreasure(treasure: Treasure, pageIndex: Int)
}