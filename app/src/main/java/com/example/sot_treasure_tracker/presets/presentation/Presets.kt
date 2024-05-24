package com.example.sot_treasure_tracker.presets.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sot_treasure_tracker.components.domain.models.CatalogCategory
import com.example.sot_treasure_tracker.components.domain.models.CategoryItem
import com.example.sot_treasure_tracker.components.presentation.CatalogCategories
import com.example.sot_treasure_tracker.components.presentation.theme.spacing
import com.example.sot_treasure_tracker.presets.data.PresetsCatalogInstance

@Composable
fun PresetsRoot(
    navController: NavController,
    viewModel: PresetsViewModel = hiltViewModel()
) {
    Presets(
        presetsCatalog = viewModel.catalog.collectAsState().value,
        setItemQuantity = { _, _ -> },
    )
}

@Composable
private fun Presets(
    presetsCatalog: List<CatalogCategory>,
    setItemQuantity: (CategoryItem, Int) -> Unit
) {
    Column(
        modifier = Modifier.padding(vertical = MaterialTheme.spacing.small)
    ) {

//        CatalogCategories(
//            categories = presetsCatalog,
//            setItemQuantity = { treasureItem, newQuantity ->
//                setItemQuantity(treasureItem, newQuantity)
//            }
//        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PresetsPreview() {
    Presets(
        presetsCatalog = PresetsCatalogInstance.catalog,
        setItemQuantity = { _, _ -> },
    )
}