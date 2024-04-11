package com.example.sot_treasure_tracker.calculator.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.databinding.ItemViewPagerBinding
import com.example.sot_treasure_tracker.components.domain.models.TreasureCategory
import com.example.sot_treasure_tracker.components.domain.models.TreasureItem

class ViewPagerAdapter(
    private val storage: List<List<TreasureCategory>>,
    private var increment: (TreasureItem, Boolean) -> Unit
) : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewPagerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, pageIndex: Int) {
        val pageContent = storage[pageIndex]

        val adapter = TreasureCategoryAdapter(storage, pageIndex, pageContent) { treasureItem, doIncrement ->
            increment(treasureItem, doIncrement)
        }
        holder.pageRecyclerView.adapter = adapter
    }

    override fun getItemCount(): Int = storage.size

    inner class ViewHolder(
        binding: ItemViewPagerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val pageRecyclerView = binding.pageRecyclerView
    }
}