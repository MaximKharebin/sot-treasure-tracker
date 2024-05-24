package com.example.sot_treasure_tracker.calculator.domain

import com.example.sot_treasure_tracker.calculator.data.TreasureCatalogInstance

interface TreasureRepository {
    fun getTreasureCatalog(): TreasureCatalogInstance
}