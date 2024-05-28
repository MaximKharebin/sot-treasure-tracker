package com.example.sot_treasure_tracker.domain

import com.example.sot_treasure_tracker.data.treasure.TreasureCatalogInstance

interface TreasureRepository {
    fun getTreasureCatalog(): TreasureCatalogInstance
}