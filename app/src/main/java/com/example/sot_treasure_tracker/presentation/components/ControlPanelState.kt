package com.example.sot_treasure_tracker.presentation.components

sealed class ControlPanelState {
    data object Opened : ControlPanelState()
    data object Closed : ControlPanelState()
}
