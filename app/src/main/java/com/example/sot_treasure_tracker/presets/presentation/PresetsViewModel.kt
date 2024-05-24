package com.example.sot_treasure_tracker.presets.presentation

import androidx.lifecycle.ViewModel
import com.example.sot_treasure_tracker.presets.data.PresetsRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PresetsViewModel : ViewModel() {

    private val _catalog = MutableStateFlow(PresetsRepositoryImpl().getPresetsCatalog().catalog)
    val catalog = _catalog.asStateFlow()
}