package com.example.sot_treasure_tracker.presets.presentation

import androidx.lifecycle.ViewModel
import com.example.sot_treasure_tracker.presets.data.PresetsRepositoryImpl
import com.example.sot_treasure_tracker.presets.domain.PresetsRepository
import com.example.sot_treasure_tracker.presets.domain.use_cases.GetPresetsCatalogUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PresetsViewModel @Inject constructor(
    getPresetsCatalogUseCase: GetPresetsCatalogUseCase
) : ViewModel() {

    private val _catalog = MutableStateFlow(getPresetsCatalogUseCase.execute())
    val catalog = _catalog.asStateFlow()
}