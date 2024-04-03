package com.example.sot_treasure_tracker.presentation.tracker

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.data.models.TreasureItem
import com.example.sot_treasure_tracker.data.models.TreasureCategory
import com.example.sot_treasure_tracker.databinding.ItemTreasureCategoryBinding

class TreasureCategoryAdapter(
    private val storage: List<List<TreasureCategory>>,
    private var pageIndex: Int,
    private var pageContent: List<TreasureCategory>,
    private var increment: (TreasureItem, Boolean) -> Unit
) : ListAdapter<TreasureItem, TreasureCategoryAdapter.ViewHolder>(DiffUtilCallback()) {

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

        holder.categoryName.text = holder.context.getString(category.categoryTitle)

        val adapter = TreasureItemAdapter(pageIndex, category.categoryItems) { treasureItem, doIncrement ->
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

class DiffUtilCallback : DiffUtil.ItemCallback<TreasureItem>() {
    override fun areItemsTheSame(oldItem: TreasureItem, newItem: TreasureItem): Boolean = true

    override fun areContentsTheSame(oldItem: TreasureItem, newItem: TreasureItem): Boolean = oldItem == newItem

}