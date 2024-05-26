package com.example.sot_treasure_tracker.components.domain.use_cases

import com.example.sot_treasure_tracker.components.domain.TreasureRepository
import javax.inject.Inject

class GetTreasureCatalogUseCase @Inject constructor(
    private val repository: TreasureRepository
) {
    fun execute() = repository.getTreasureCatalog().catalog
}