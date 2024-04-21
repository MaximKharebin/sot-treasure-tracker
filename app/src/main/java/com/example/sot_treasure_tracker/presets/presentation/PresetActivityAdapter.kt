package com.example.sot_treasure_tracker.presets.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.databinding.ItemActivityBinding
import com.example.sot_treasure_tracker.presets.domain.models.PresetActivity

class PresetActivityAdapter(
    val items: List<PresetActivity>
) : RecyclerView.Adapter<PresetActivityAdapter.ViewHolder>() {

    inner class ViewHolder(
        binding: ItemActivityBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val context: Context = binding.root.context
        val titleTextView = binding.titleTextView
        val rewardsRecyclerView = binding.rewardsRecyclerView
        val counterCustomView = binding.counterCustomView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemActivityBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = items[position]
        val adapter = PresetRewardAdapter(category.items)

        with(holder) {
            titleTextView.text = context.getString(category.titleId)
            rewardsRecyclerView.adapter = adapter
        }
    }
}