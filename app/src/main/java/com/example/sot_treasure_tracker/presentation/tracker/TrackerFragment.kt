package com.example.sot_treasure_tracker.presentation.tracker

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
import com.example.sot_treasure_tracker.data.models.TreasureItem
import com.example.sot_treasure_tracker.data.models.TreasureCategory
import com.example.sot_treasure_tracker.databinding.FragmentMainBinding
import com.example.sot_treasure_tracker.components.ControlPanelState
import com.example.sot_treasure_tracker.components.EmissaryGrades
import com.example.sot_treasure_tracker.presentation.tracker.components.Event
import com.example.sot_treasure_tracker.components.RepresentableFractions
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
            setupTabs()
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

        collectLatestFlow(viewModel.representedFraction) { fraction ->
            when (fraction) {
                RepresentableFractions.GOLD_HOARDERS -> binding.spinner.setSelection(
                    RepresentableFractions.GOLD_HOARDERS.ordinal
                )

                RepresentableFractions.MERCHANT_ALLIANCE -> binding.spinner.setSelection(
                    RepresentableFractions.MERCHANT_ALLIANCE.ordinal
                )

                RepresentableFractions.ORDER_OF_SOULS -> binding.spinner.setSelection(
                    RepresentableFractions.ORDER_OF_SOULS.ordinal
                )

                RepresentableFractions.ATHENAS_FORTUNE -> binding.spinner.setSelection(
                    RepresentableFractions.ATHENAS_FORTUNE.ordinal
                )

                RepresentableFractions.REAPERS_BONES -> binding.spinner.setSelection(
                    RepresentableFractions.REAPERS_BONES.ordinal
                )

                RepresentableFractions.GUILD -> binding.spinner.setSelection(RepresentableFractions.GUILD.ordinal)
                null -> {}
            }
        }

        collectLatestFlow(viewModel.emissaryGrade) { grade ->
            when (grade) {
                EmissaryGrades.FIRST_GRADE -> binding.seekBar.progress =
                    EmissaryGrades.FIRST_GRADE.ordinal

                EmissaryGrades.SECOND_GRADE -> binding.seekBar.progress =
                    EmissaryGrades.SECOND_GRADE.ordinal

                EmissaryGrades.THIRD_GRADE -> binding.seekBar.progress =
                    EmissaryGrades.THIRD_GRADE.ordinal

                EmissaryGrades.FORTH_GRADE -> binding.seekBar.progress =
                    EmissaryGrades.FORTH_GRADE.ordinal

                EmissaryGrades.FIFTH_GRADE -> binding.seekBar.progress =
                    EmissaryGrades.FIFTH_GRADE.ordinal

                null -> {}
            }
        }

        collectLatestFlow(viewModel.controlPanelState) { state ->
            when (state) {
                ControlPanelState.Closed -> {
                    setButtonIcon(R.drawable.ic_double_arrow_up)
                    binding.seekBar.isVisible = false
                    binding.spinner.isVisible = false
                }

                ControlPanelState.Opened -> {
                    setButtonIcon(R.drawable.ic_double_arrow_down)
                    binding.seekBar.isVisible = true
                    binding.spinner.isVisible = true
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
                viewModel.onEvent(Event.ChangeRepresentedFraction(RepresentableFractions.entries[position]))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                viewModel.onEvent(Event.ChangeEmissaryGrade(EmissaryGrades.entries[progress]))
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}

        })

        binding.button.setOnClickListener {
            when (viewModel.controlPanelState.value) {
                ControlPanelState.Closed -> viewModel.onEvent(
                    Event.CollapseControls(ControlPanelState.Opened)
                )

                ControlPanelState.Opened -> viewModel.onEvent(
                    Event.CollapseControls(ControlPanelState.Closed)
                )
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun <T> collectLatestFlow(flow: Flow<T>, collect: suspend (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collectLatest(collect)
            }
        }
    }

    private fun incrementTreasure(treasureItem: TreasureItem, doIncrement: Boolean) {
        if (doIncrement)
            viewModel.onEvent(Event.IncrementTreasure(treasureItem, 0))
        else
            viewModel.onEvent(Event.DecrementTreasure(treasureItem, 0))
    }

    private fun setupViewPager(storage: List<List<TreasureCategory>>) {
        val adapter = ViewPagerAdapter(storage) { treasure, doIncrement ->
            incrementTreasure(treasure, doIncrement)
        }
        binding.viewPager.adapter = adapter
    }

    private fun setupTabs() {
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

    private fun setButtonIcon(drawable: Int) {
        binding.button.setCompoundDrawablesRelativeWithIntrinsicBounds(
            null,
            null,
            AppCompatResources.getDrawable(
                requireContext(),
                drawable
            ),
            null
        )
    }
}