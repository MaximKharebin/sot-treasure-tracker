package com.example.sot_treasure_tracker.calculator.domain.use_cases

import com.example.sot_treasure_tracker.calculator.domain.Repository
import javax.inject.Inject

class GetTreasureCatalogUseCase @Inject constructor(
    private val repository: Repository
) {
    fun execute() = repository.getTreasureCatalog().catalog
}