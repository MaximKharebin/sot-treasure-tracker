package com.example.sot_treasure_tracker.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.SeekBar
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.TreasureStorage
import com.example.sot_treasure_tracker.model.Fraction
import com.example.sot_treasure_tracker.data.model.Treasure
import com.example.sot_treasure_tracker.databinding.FragmentMainBinding
import com.example.sot_treasure_tracker.presentation.adapters.ViewPagerAdapter
import com.example.sot_treasure_tracker.model.ControlPanelState
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainFragment : Fragment(), TreasureClickListener {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.treasuresTotalValue.collectLatest { treasureValues ->
                    binding.goldTextView.text = "${treasureValues.gold.first}–${treasureValues.gold.last}"
                    binding.doubloonsTextView.text = treasureValues.doubloons.toString()
                    binding.valueTextView.text = treasureValues.value.toString()
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.runningEmissary.collectLatest { fraction ->
                    when (fraction) {
                        Fraction.GOLD_HOARDERS -> binding.spinner.setSelection(0)
                        Fraction.MERCHANT_ALLIANCE -> binding.spinner.setSelection(1)
                        Fraction.ORDER_OF_SOULS -> binding.spinner.setSelection(2)
                        Fraction.ATHENAS_FORTUNE -> binding.spinner.setSelection(3)
                        Fraction.REAPERS_BONES -> binding.spinner.setSelection(4)
                        Fraction.OTHER -> binding.spinner.setSelection(5)
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.emissaryLevel.collectLatest { level ->
                    binding.seekBar.progress = level
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.controlPanelState.collectLatest { state ->
                    when (state) {
                        ControlPanelState.Closed -> {
                            binding.seekBar.isVisible = false
                            binding.spinner.isVisible = false
                            binding.button.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_double_arrow_up, 0)
                        }
                        ControlPanelState.Opened -> {
                            binding.seekBar.isVisible = true
                            binding.spinner.isVisible = true
                            binding.button.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_double_arrow_down, 0)
                        }
                    }
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
                viewModel.setRunningEmissary(Fraction.entries[position])
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {  }
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.setEmissaryLevel(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {  }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {  }

        })

        binding.button.setOnClickListener {
            when (viewModel.controlPanelState.value) {
                ControlPanelState.Closed -> viewModel.setControlPanelState(ControlPanelState.Opened)
                ControlPanelState.Opened -> viewModel.setControlPanelState(ControlPanelState.Closed)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(this, TreasureStorage)
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

    override fun incrementTreasure(treasure: Treasure, pageIndex: Int) {

    }

    override fun decrementTreasure(treasure: Treasure, pageIndex: Int) {

    }
}