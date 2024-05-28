package com.example.sot_treasure_tracker.domain.use_cases

import com.example.sot_treasure_tracker.domain.Repository
import javax.inject.Inject

class GetTreasureCatalogUseCase @Inject constructor(
    private val repository: Repository
) {
    fun execute() = repository.getTreasureCatalog().catalog
}