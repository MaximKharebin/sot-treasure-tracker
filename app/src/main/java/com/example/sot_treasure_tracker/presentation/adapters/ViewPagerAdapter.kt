package com.example.sot_treasure_tracker.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.databinding.ItemViewPagerBinding
import com.example.sot_treasure_tracker.data.TreasureStorage
import com.example.sot_treasure_tracker.presentation.MainFragment

class ViewPagerAdapter(
    private val fragment: MainFragment,
    private val treasureStorage: TreasureStorage
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
        val pageContent = treasureStorage.storage[pageIndex]

        val adapter = TreasureCategoryAdapter(fragment, treasureStorage, pageIndex, pageContent)
        holder.pageRecyclerView.adapter = adapter
    }

    override fun getItemCount(): Int = treasureStorage.storage.size

    inner class ViewHolder (
        binding: ItemViewPagerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val pageRecyclerView = binding.pageRecyclerView
    }
}