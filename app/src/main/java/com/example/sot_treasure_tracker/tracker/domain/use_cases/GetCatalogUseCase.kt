package com.example.sot_treasure_tracker.tracker.domain.use_cases

import com.example.sot_treasure_tracker.tracker.data.Repository

class GetCatalogUseCase {

    private val repository = Repository()

    fun execute() = repository.getCatalog()
}