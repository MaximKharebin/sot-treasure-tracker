package com.example.sot_treasure_tracker.presets.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.databinding.ItemCategoryBinding
import com.example.sot_treasure_tracker.presets.domain.models.PresetCategory

class PresetCategoryAdapter(
    val items: List<PresetCategory>
) : RecyclerView.Adapter<PresetCategoryAdapter.ViewHolder>() {

    inner class ViewHolder(
        binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val context: Context = binding.root.context
        val titleTextView = binding.titleTextView
        val activitiesRecyclerView = binding.contentRecyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCategoryBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = items[position]
        val adapter = PresetActivityAdapter(category.items)

        with(holder) {
            titleTextView.text = context.getString(category.titleId)
            activitiesRecyclerView.adapter = adapter
        }
    }
}