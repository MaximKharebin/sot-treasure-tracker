package com.example.sot_treasure_tracker.presets.domain.use_cases

import com.example.sot_treasure_tracker.presets.domain.PresetsRepository
import javax.inject.Inject

class GetPresetsCatalogUseCase @Inject constructor(
    private val repository: PresetsRepository
) {

    fun execute() = repository.getPresetsCatalog().catalog
}