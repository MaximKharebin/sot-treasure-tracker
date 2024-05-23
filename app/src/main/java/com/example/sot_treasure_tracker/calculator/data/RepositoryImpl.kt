package com.example.sot_treasure_tracker.calculator.data

import com.example.sot_treasure_tracker.calculator.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val treasureCatalog: TreasureCatalog
) : Repository {
    override fun getTreasureCatalog() = treasureCatalog.catalog

}