package com.example.sot_treasure_tracker.data

import com.example.sot_treasure_tracker.domain.TreasureRepository
import javax.inject.Inject

class TreasureRepositoryImpl @Inject constructor(
    private val treasureCatalog: TreasureCatalog
) : TreasureRepository {
    override fun getTreasureCatalog() = treasureCatalog.catalog

}