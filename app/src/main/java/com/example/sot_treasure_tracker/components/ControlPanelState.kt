package com.example.sot_treasure_tracker.components

sealed class ControlPanelState {
    data object Opened : ControlPanelState()
    data object Closed : ControlPanelState()
}
