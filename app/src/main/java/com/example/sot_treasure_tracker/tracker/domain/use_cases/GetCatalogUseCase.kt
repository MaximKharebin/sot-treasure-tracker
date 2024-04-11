package com.example.sot_treasure_tracker.calculator.domain.use_cases

import com.example.sot_treasure_tracker.calculator.data.Repository

class GetCatalogUseCase {

    private val repository = Repository()

    fun execute() = repository.getCatalog()
}