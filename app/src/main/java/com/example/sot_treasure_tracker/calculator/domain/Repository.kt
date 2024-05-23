package com.example.sot_treasure_tracker.calculator.domain

import com.example.sot_treasure_tracker.calculator.data.catalog_instance.TreasureCatalogInstance

interface Repository {
    fun getTreasureCatalog(): TreasureCatalogInstance
}