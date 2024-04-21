package com.example.sot_treasure_tracker.util.presentation

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.databinding.SampleCounterCustomViewBinding


class CounterCustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    var binding: SampleCounterCustomViewBinding

    init {
        val view = inflate(context, R.layout.sample_counter_custom_view, this)
        binding = SampleCounterCustomViewBinding.bind(view)
    }
}