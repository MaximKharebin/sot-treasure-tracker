package com.example.sot_treasure_tracker.data

import com.example.sot_treasure_tracker.domain.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val catalogStorage: CatalogStorage
): Repository {

    override fun getTreasureCatalog() = catalogStorage.treasureCatalog

    override fun getPresetsCatalog() = catalogStorage.presetCatalog

}