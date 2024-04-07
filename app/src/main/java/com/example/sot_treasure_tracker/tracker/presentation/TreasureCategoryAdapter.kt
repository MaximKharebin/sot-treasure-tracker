package com.example.sot_treasure_tracker.tracker.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.databinding.ItemTreasureCategoryBinding
import com.example.sot_treasure_tracker.tracker.domain.models.TreasureCategory
import com.example.sot_treasure_tracker.tracker.domain.models.TreasureItem

class TreasureCategoryAdapter(
    private val storage: List<List<TreasureCategory>>,
    private var pageIndex: Int,
    private var pageContent: List<TreasureCategory>,
    private var increment: (TreasureItem, Boolean) -> Unit
) : RecyclerView.Adapter<TreasureCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTreasureCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = pageContent[position]

        holder.categoryName.text = holder.context.getString(category.titleId)

        val adapter = TreasureItemAdapter(pageIndex, category.items) { treasureItem, doIncrement ->
            increment(treasureItem, doIncrement)
        }
        holder.categoryRecyclerView.adapter = adapter
    }

    override fun getItemCount(): Int = storage[pageIndex].size

    inner class ViewHolder(
        binding: ItemTreasureCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val context: Context = binding.root.context

        val categoryRecyclerView = binding.categoryRecyclerView
        val categoryName = binding.categoryNameTextView
    }
}