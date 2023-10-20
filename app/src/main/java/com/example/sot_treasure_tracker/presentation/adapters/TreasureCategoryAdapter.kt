package com.example.sot_treasure_tracker.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.databinding.ItemTreasureCategoryBinding
import com.example.sot_treasure_tracker.data.model.TreasureCategory
import com.example.sot_treasure_tracker.data.TreasureStorage
import com.example.sot_treasure_tracker.data.model.Treasure
import com.example.sot_treasure_tracker.presentation.MainFragment

class TreasureCategoryAdapter(
    private var fragment: MainFragment,
    private val treasureStorage: TreasureStorage,
    private var pageIndex: Int,
    private var pageContent: List<TreasureCategory>
) : RecyclerView.Adapter<TreasureCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int, ) : ViewHolder {
        val binding = ItemTreasureCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = pageContent[position]

        holder.categoryName.text = fragment.getString(category.categoryTitle)

        val adapter = TreasureAdapter(fragment, pageIndex, category.categoryItems)
        holder.categoryRecyclerView.adapter = adapter
    }

    override fun getItemCount(): Int = treasureStorage.storage[pageIndex].size

    inner class ViewHolder (
        binding: ItemTreasureCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val categoryRecyclerView = binding.categoryRecyclerView
        val categoryName = binding.categoryNameTextView
    }
}