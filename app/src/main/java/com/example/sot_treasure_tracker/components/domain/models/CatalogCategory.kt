package com.example.sot_treasure_tracker.components.domain.models

interface CatalogCategory {
    val titleId: Int
    val items: List<CategoryItem>
}