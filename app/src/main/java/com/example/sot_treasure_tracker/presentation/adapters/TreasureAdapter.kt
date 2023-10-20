package com.example.sot_treasure_tracker.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.model.Price
import com.example.sot_treasure_tracker.data.model.Treasure
import com.example.sot_treasure_tracker.databinding.ItemTreasureBinding
import com.example.sot_treasure_tracker.presentation.MainFragment
import com.google.android.material.snackbar.Snackbar

class TreasureAdapter(
    private var fragment: MainFragment,
    private var pageIndex: Int,
    private var category: List<Treasure>
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
                is Price.Gold ->{
                    val price = (treasure.price).price
                    treasurePrice.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.img_currency_gold, 0, 0, 0)
                    treasurePrice.text = fragment.getString(
                        R.string.treasure_item_price,
                        price.first,
                        price.last
                    )
                }

                is Price.Doubloons -> {
                    val price = (treasure.price).price
                    treasurePrice.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.img_currency_doubloons, 0, 0, 0)
                    treasurePrice.text = fragment.getString(
                        R.string.treasure_item_quantity,
                        price,
                    )
                }
            }

            treasureName.text = fragment.getString(treasure.name)
            treasureValue.text = fragment.getString(
                R.string.treasure_item_emissary_value,
                treasure.emissaryValue
            )
            treasureQuantity.text = fragment.getString(
                R.string.treasure_item_quantity,
                treasure.quantity
            )

            incrementButton.setOnClickListener {
                Snackbar.make(it, "Increment treasure: ${treasure.name}", Snackbar.LENGTH_LONG).show()
                fragment.incrementTreasure(treasure, pageIndex)
            }

            decrementButton.setOnClickListener {
                Snackbar.make(it, "Decrement treasure: ${treasure.name}", Snackbar.LENGTH_LONG).show()
                fragment.decrementTreasure(treasure, pageIndex)
            }
        }
    }

    override fun getItemCount(): Int = category.size

    inner class ViewHolder (
        binding: ItemTreasureBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val treasureName = binding.nameTextView
        val treasurePrice = binding.priceTextView
        val treasureValue = binding.valueTextView
        val treasureQuantity = binding.quantityTextView

        val incrementButton = binding.incrementButton
        val decrementButton = binding.decrementButton
    }
}