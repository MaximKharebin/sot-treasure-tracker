package com.example.sot_treasure_tracker.calculator.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.databinding.ItemTreasureBinding
import com.example.sot_treasure_tracker.util.data.models.TreasureItemDto
import com.example.sot_treasure_tracker.util.domain.models.Price
import com.example.sot_treasure_tracker.util.domain.models.TreasureItem

class TreasureItemAdapter(
    private var pageIndex: Int,
    private var category: List<TreasureItem>,
    private var increment: (TreasureItem, Boolean) -> Unit
) : RecyclerView.Adapter<TreasureItemAdapter.ViewHolder>() {

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTreasureBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = category.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val treasure = category[position]

        with(holder) {
            when (treasure.price) {
                is Price.GoldRange -> {
                    val price = (treasure.price as Price.GoldRange).gold
                    setCurrencyImg(holder, R.drawable.img_currency_gold)
                    treasurePrice.text = context.getString(
                        R.string.treasure_price_range,
                        price.first,
                        price.last
                    )
                }

                is Price.Doubloons -> {
                    val price = (treasure.price as Price.Doubloons).doubloons
                    setCurrencyImg(holder, R.drawable.img_currency_doubloons)
                    treasurePrice.text = context.getString(
                        R.string.treasure_price_single,
                        price,
                    )
                }
            }

            treasureName.text = context.getString(treasure.nameId)
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
                updateCategory(1, category, treasure as TreasureItemDto)
            }

            decrementButton.setOnClickListener {
                if (treasure.quantity > 0) {
                    increment(treasure, false)
                    updateCategory(-1, category, treasure as TreasureItemDto)
                }
            }
        }
    }

    private fun updateCategory(
        changeBy: Int,
        category: List<TreasureItem>,
        treasure: TreasureItemDto
    ) {
        val treasureIndex = category.indexOf(treasure)
        val newCategory = ArrayList(category)
        val updatedQuantity = treasure.copy(quantity = treasure.quantity + changeBy)
        newCategory[treasureIndex] = updatedQuantity

        val diffCallback = ItemCardDiffCallback(category, newCategory)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this@TreasureItemAdapter)
    }

    private fun setCurrencyImg(holder: ViewHolder, drawable: Int) {
        holder.treasurePrice.setCompoundDrawablesRelativeWithIntrinsicBounds(
            drawable, 0, 0, 0
        )
    }
}