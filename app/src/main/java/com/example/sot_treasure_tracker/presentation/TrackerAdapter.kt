package com.example.sot_treasure_tracker.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.data.models.TreasureItem
import com.example.sot_treasure_tracker.databinding.ItemViewPagerBinding
import com.example.sot_treasure_tracker.data.models.TreasureCategory

class TrackerAdapter(
    private val storage: List<List<TreasureCategory>>,
    private var increment: (TreasureItem, Boolean) -> Unit
) : RecyclerView.Adapter<TrackerAdapter.ViewHolder>() {

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

        val context = binding.root.context

        val pageRecyclerView = binding.pageRecyclerView
    }
}