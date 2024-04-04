package com.example.sot_treasure_tracker.presentation.tracker

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.components.Price
import com.example.sot_treasure_tracker.data.models.TreasureItem
import com.example.sot_treasure_tracker.databinding.ItemTreasureBinding

class TreasureItemAdapter(
    private var pageIndex: Int,
    private var category: List<TreasureItem>,
    private var increment: (TreasureItem, Boolean) -> Unit
) : RecyclerView.Adapter<TreasureItemAdapter.ViewHolder>() {

    private fun updateCategory(
        changeBy: Int,
        category: List<TreasureItem>,
        treasure: TreasureItem
    ) {
        val treasureIndex = category.indexOf(treasure)
        val newCategory = ArrayList(category)
        val updatedQuantity = treasure.copy(quantity = treasure.quantity + changeBy)
        newCategory[treasureIndex] = updatedQuantity

        val diffCallback = ItemCardDiffCallback(category, newCategory)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this@TreasureItemAdapter)
    }

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
                is Price.GoldRange -> {
                    val price = (treasure.price).gold
                    setCurrencyImg(holder, R.drawable.img_currency_gold)
                    treasurePrice.text = context.getString(
                        R.string.treasure_price_range,
                        price.first,
                        price.last
                    )
                }

                is Price.Doubloons -> {
                    val price = (treasure.price).doubloons
                    setCurrencyImg(holder, R.drawable.img_currency_doubloons)
                    treasurePrice.text = context.getString(
                        R.string.treasure_price_single,
                        price,
                    )
                }
            }

            treasureName.text = context.getString(treasure.name)
            treasureValue.text = context.getString(
                R.string.treasure_emissary_value,
                treasure.emissaryValue
            )
            treasureQuantity.text = context.getString(
                R.string.treasure_quantity,
                treasure.quantity
            )

            incrementButton.setOnClickListener {
                increment(treasure, true)
                updateCategory(1, category, treasure)
            }

            decrementButton.setOnClickListener {
                if (treasure.quantity > 0) {
                    increment(treasure, false)
                    updateCategory(-1, category, treasure)
                }
            }
        }
    }

    override fun getItemCount(): Int = category.size

    private fun setCurrencyImg(holder: ViewHolder, drawable: Int) {
        holder.treasurePrice.setCompoundDrawablesRelativeWithIntrinsicBounds(
            drawable, 0, 0, 0
        )
    }

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

    inner class ItemCardDiffCallback(
        private val oldList: List<TreasureItem>,
        private val newList: List<TreasureItem>,
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = true

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldQuantity = oldList[oldItemPosition].quantity
            val newQuantity = newList[newItemPosition].quantity
            return (oldQuantity == newQuantity)
        }
    }
}