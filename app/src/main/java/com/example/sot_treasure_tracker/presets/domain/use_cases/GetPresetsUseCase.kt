package com.example.sot_treasure_tracker.presets.domain.use_cases

import com.example.sot_treasure_tracker.presets.data.Repository

class GetPresetsUseCase {

    val repository = Repository()

    fun execute() = repository.getPresets()
}