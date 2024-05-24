package com.example.sot_treasure_tracker.calculator.domain.use_cases

import com.example.sot_treasure_tracker.calculator.domain.TreasureRepository
import javax.inject.Inject

class GetTreasureCatalogUseCase @Inject constructor(
    private val repository: TreasureRepository
) {
    fun execute() = repository.getTreasureCatalog().catalog
}