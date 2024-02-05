package com.example.sot_treasure_tracker.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.data.model.Treasure
import com.example.sot_treasure_tracker.data.model.TreasureCategory
import com.example.sot_treasure_tracker.databinding.ItemTreasureCategoryBinding

class TreasureCategoryAdapter(
    private val storage: List<List<TreasureCategory>>,
    private var pageIndex: Int,
    private var pageContent: List<TreasureCategory>,
    private var increment: (Treasure) -> Unit
) : ListAdapter<Treasure, TreasureCategoryAdapter.ViewHolder>(DiffUtilCallback()) {

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

        val adapter = TreasureAdapter(pageIndex, category.categoryItems) { increment(it) }
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

class DiffUtilCallback : DiffUtil.ItemCallback<Treasure>() {
    override fun areItemsTheSame(oldItem: Treasure, newItem: Treasure): Boolean = true

    override fun areContentsTheSame(oldItem: Treasure, newItem: Treasure): Boolean = oldItem == newItem

}