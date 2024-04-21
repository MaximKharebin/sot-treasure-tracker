package com.example.sot_treasure_tracker.calculator.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.databinding.ItemCategoryBinding
import com.example.sot_treasure_tracker.util.domain.models.TreasureCategory
import com.example.sot_treasure_tracker.util.domain.models.TreasureItem

class TreasureCategoryAdapter(
    private var pageIndex: Int,
    private var pageContent: List<TreasureCategory>,
    private var increment: (TreasureItem, Boolean) -> Unit
) : RecyclerView.Adapter<TreasureCategoryAdapter.ViewHolder>() {

    inner class ViewHolder(binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        val context: Context = binding.root.context
        val titleTextView = binding.titleTextView
        val treasureRecyclerView = binding.contentRecyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = pageContent.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = pageContent[position]
        val adapter = TreasureItemAdapter(pageIndex, category.items, increment)

        with(holder) {
            titleTextView.text = holder.context.getString(category.titleId)
            treasureRecyclerView.adapter = adapter
        }
    }
}