package com.example.sot_treasure_tracker.presentation.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.model.Price
import com.example.sot_treasure_tracker.data.model.Treasure
import com.example.sot_treasure_tracker.databinding.ItemTreasureBinding
import com.google.android.material.snackbar.Snackbar

class TreasureAdapter(
    private var pageIndex: Int,
    private var category: List<Treasure>,
    private var increment: (Treasure) -> Unit
) : RecyclerView.Adapter<TreasureAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemTreasureBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val treasure = category[position]

        holder.apply {
            when (treasure.price) {
                is Price.Gold -> {
                    val price = (treasure.price).gold
                    treasurePrice.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        R.drawable.img_currency_gold,
                        0,
                        0,
                        0
                    )
                    treasurePrice.text = context.getString(
                        R.string.treasure_item_price,
                        price.first,
                        price.last
                    )
                }

                is Price.Doubloons -> {
                    val price = (treasure.price).doubloons
                    treasurePrice.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        R.drawable.img_currency_doubloons,
                        0,
                        0,
                        0
                    )
                    treasurePrice.text = context.getString(
                        R.string.treasure_item_quantity,
                        price,
                    )
                }
            }

            treasureName.text = context.getString(treasure.name)
            treasureValue.text = context.getString(
                R.string.treasure_item_emissary_value,
                treasure.emissaryValue
            )
            treasureQuantity.text = context.getString(
                R.string.treasure_item_quantity,
                treasure.quantity
            )

            incrementButton.setOnClickListener {
                Snackbar.make(it, "Increment treasure: ${treasure.quantity}", Snackbar.LENGTH_SHORT)
                    .show()
                increment(treasure)
            }

            decrementButton.setOnClickListener {
                Snackbar.make(it, "Decrement treasure: ${treasure.quantity}", Snackbar.LENGTH_SHORT)
                    .show()
                increment(treasure)
            }
        }
    }

    override fun getItemCount(): Int = category.size

    inner class ViewHolder(
        binding: ItemTreasureBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val context: Context = binding.root.context

        val treasureName = binding.nameTextView
        val treasurePrice = binding.priceTextView
        val treasureValue = binding.valueTextView
        val treasureQuantity = binding.quantityTextView

        val incrementButton = binding.incrementButton
        val decrementButton = binding.decrementButton
    }
}