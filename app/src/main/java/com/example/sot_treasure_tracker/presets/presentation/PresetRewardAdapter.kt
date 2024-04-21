package com.example.sot_treasure_tracker.presets.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.databinding.ItemActivityRewardBinding
import com.example.sot_treasure_tracker.presets.domain.models.PresetReward

class PresetRewardAdapter(
    val items: List<PresetReward>
) : RecyclerView.Adapter<PresetRewardAdapter.ViewHolder>() {

    inner class ViewHolder(
        binding: ItemActivityRewardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val context: Context = binding.root.context
        val titleTextView = binding.treasureTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemActivityRewardBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        with(holder) {
            val text = context.getString(item.treasureId) + " – " + item.quantity
            titleTextView.text = text
        }
    }
}