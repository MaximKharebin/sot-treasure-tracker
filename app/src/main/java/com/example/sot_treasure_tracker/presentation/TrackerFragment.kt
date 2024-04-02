package com.example.sot_treasure_tracker.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.SeekBar
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.models.Catalog
import com.example.sot_treasure_tracker.data.models.TreasureItem
import com.example.sot_treasure_tracker.data.models.TreasureCategory
import com.example.sot_treasure_tracker.components.Fraction
import com.example.sot_treasure_tracker.databinding.FragmentMainBinding
import com.example.sot_treasure_tracker.presentation.components.ControlPanelState
import com.example.sot_treasure_tracker.presentation.components.Event
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TrackerFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TrackerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        collectLatestFlow(viewModel.catalog) { catalog ->
            setupViewPager(catalog.items)
        }

        collectLatestFlow(viewModel.costValues) { costValues ->
            val goldRangeString = listOf(
                costValues.gold.first,
                costValues.gold.last
            ).joinToString("–")

            binding.goldTextView.text = goldRangeString
            binding.doubloonsTextView.text = costValues.doubloons.toString()
            binding.valueTextView.text = costValues.emissaryValue.toString()
        }

        collectLatestFlow(viewModel.emissaryValues) { emissaryValues ->
            when (emissaryValues.fraction) {
                Fraction.GOLD_HOARDERS -> binding.spinner.setSelection(Fraction.GOLD_HOARDERS.ordinal)
                Fraction.MERCHANT_ALLIANCE -> binding.spinner.setSelection(Fraction.MERCHANT_ALLIANCE.ordinal)
                Fraction.ORDER_OF_SOULS -> binding.spinner.setSelection(Fraction.ORDER_OF_SOULS.ordinal)
                Fraction.ATHENAS_FORTUNE -> binding.spinner.setSelection(Fraction.ATHENAS_FORTUNE.ordinal)
                Fraction.REAPERS_BONES -> binding.spinner.setSelection(Fraction.REAPERS_BONES.ordinal)
                Fraction.SHARED -> binding.spinner.setSelection(Fraction.GOLD_HOARDERS.ordinal)
                Fraction.UNIQUE -> binding.spinner.setSelection(Fraction.GOLD_HOARDERS.ordinal)
            }

            binding.seekBar.progress = emissaryValues.level
        }

        collectLatestFlow(viewModel.controlPanelState) { state ->
            when (state) {
                ControlPanelState.Closed -> {
                    binding.seekBar.isVisible = false
                    binding.spinner.isVisible = false
                    binding.button.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        null,
                        null,
                        AppCompatResources.getDrawable(
                            requireContext(),
                            R.drawable.ic_double_arrow_up
                        ),
                        null
                    )
                }

                ControlPanelState.Opened -> {
                    binding.seekBar.isVisible = true
                    binding.spinner.isVisible = true
                    binding.button.setCompoundDrawablesRelativeWithIntrinsicBounds(
                        null,
                        null,
                        AppCompatResources.getDrawable(
                            requireContext(),
                            R.drawable.ic_double_arrow_down
                        ),
                        null
                    )
                }
            }
        }

        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                viewModel.onEvent(Event.ChangeEmissaryFraction(Fraction.entries[position]))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.onEvent(Event.ChangeEmissaryLevel(progress))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        binding.button.setOnClickListener {
            when (viewModel.controlPanelState.value) {
                ControlPanelState.Closed -> viewModel.onEvent(
                    Event.CollapseControls(
                        ControlPanelState.Opened
                    )
                )

                ControlPanelState.Opened -> viewModel.onEvent(
                    Event.CollapseControls(
                        ControlPanelState.Closed
                    )
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun incrementTreasure(treasureItem: TreasureItem, doIncrement: Boolean) {
        if (doIncrement)
            viewModel.onEvent(Event.IncrementTreasure(treasureItem, 0))
        else
            viewModel.onEvent(Event.DecrementTreasure(treasureItem, 0))
    }


    private fun <T> collectLatestFlow(flow: Flow<T>, collect: suspend (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collectLatest(collect)
            }
        }
    }


    private fun setupViewPager(storage: List<List<TreasureCategory>>) {
        val adapter = TrackerAdapter(storage) { treasure, doIncrement -> incrementTreasure(treasure, doIncrement) }
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val icons = listOf(
                R.drawable.img_gh_logo,
                R.drawable.img_ma_logo,
                R.drawable.img_oos_logo,
                R.drawable.img_af_logo,
                R.drawable.img_rb_logo,
                R.drawable.img_br_logo,
            )
            tab.setIcon(icons[position])
        }.attach()
    }
}