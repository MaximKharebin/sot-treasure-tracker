package com.example.sot_treasure_tracker.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.databinding.ItemViewPagerBinding
import com.example.sot_treasure_tracker.data.TreasureStorage
import com.example.sot_treasure_tracker.presentation.MainFragment

class ViewPagerAdapter(
    private val fragment: MainFragment,
    private val storage: TreasureStorage
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
        val pageContent = when (pageIndex) {
            0 -> storage.goldHoardersStorage
            1 -> storage.merchantAllianceStorage
            2 -> storage.orderOfSoulsStorage
            3 -> storage.athenaFortuneStorage
            4 -> storage.otherStorage
            5 -> storage.otherStorage
            else -> null
        }

        val adapter = TreasureCategoryAdapter(fragment, storage, pageIndex, pageContent)
        holder.pageRecyclerView.adapter = adapter
    }

    /* TODO("Hardcoded return value. Need to do something with the way [storage] works") */
    override fun getItemCount(): Int = 6

    inner class ViewHolder (
        binding: ItemViewPagerBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val pageRecyclerView = binding.pageRecyclerView
    }
}