package com.example.sot_treasure_tracker.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.databinding.ItemTreasureCategoryBinding
import com.example.sot_treasure_tracker.data.TreasureCategory
import com.example.sot_treasure_tracker.data.TreasureStorage
import com.example.sot_treasure_tracker.data.model.AbstractTreasure
import com.example.sot_treasure_tracker.presentation.MainFragment

class TreasureCategoryAdapter(
    private var fragment: MainFragment,
    private val storage: TreasureStorage,
    private var pageIndex: Int,
    private var pageContent: List<TreasureCategory<out AbstractTreasure>>?
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
        pageContent.let {
            if (!it.isNullOrEmpty()) {
                val category = when (pageIndex) {
                    0 -> it[position]
                    1 -> it[position]
                    2 -> it[position]
                    3 -> it[position]
                    4 -> it[position]
                    5 -> it[position]
                    else -> it[position]
                }

                holder.categoryName.text = fragment.getString(category.categoryTitle)

                val adapter = TreasureAdapter(fragment, pageIndex, it[position])
                holder.categoryRecyclerView.adapter = adapter
            }
        }

    }

    override fun getItemCount(): Int = when (pageIndex) {
        0 -> storage.goldHoardersStorage.size
        1 -> storage.merchantAllianceStorage.size
        2 -> storage.orderOfSoulsStorage.size
        3 -> storage.athenaFortuneStorage.size
        4 -> storage.otherStorage.size
        5 -> storage.otherStorage.size
        else -> 0
    }

    inner class ViewHolder (
        binding: ItemTreasureCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val categoryRecyclerView = binding.categoryRecyclerView
        val categoryName = binding.categoryNameTextView
    }
}