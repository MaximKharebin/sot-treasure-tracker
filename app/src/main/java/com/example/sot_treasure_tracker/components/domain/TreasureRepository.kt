package com.example.sot_treasure_tracker.components.domain

import com.example.sot_treasure_tracker.components.data.TreasureCatalogInstance

interface TreasureRepository {
    fun getTreasureCatalog(): TreasureCatalogInstance
}