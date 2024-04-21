package com.example.sot_treasure_tracker.util.domain.use_cases

import com.example.sot_treasure_tracker.util.data.Repository

class GetCatalogUseCase {

    private val repository = Repository()

    fun execute() = repository.getCatalog()
}