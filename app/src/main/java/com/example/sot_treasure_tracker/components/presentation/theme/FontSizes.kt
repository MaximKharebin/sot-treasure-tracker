package com.example.sot_treasure_tracker.components.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

data class FontSize(
    val default: TextUnit = 14.sp,
    val label: TextUnit = 12.sp,
    val body: TextUnit = 14.sp,
    val heading: TextUnit = 20.sp,
    val display: TextUnit = 48.sp
)

val LocalFontSize = compositionLocalOf { FontSize() }

val MaterialTheme.fontSize: FontSize
    @Composable
    @ReadOnlyComposable
    get() = LocalFontSize.current
