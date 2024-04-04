package com.example.sot_treasure_tracker.presentation.tracker

import android.graphics.BlendMode
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
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
import com.google.android.material.snackbar.Snackbar
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
            Log.d("TAGTAGTAG", "Cost Values: ${costValues}")
            binding.goldTextView.text = getString(
                R.string.treasure_price_range,
                costValues.gold.first,
                costValues.gold.last
            )

            binding.doubloonsTextView.text = getString(
                R.string.treasure_price_single,
                costValues.doubloons
            )

            binding.valueTextView.text = getString(
                R.string.treasure_emissary_value,
                costValues.emissaryValue
            )
        }

        collectLatestFlow(viewModel.representedFraction) { fraction ->
            val fractions = resources.getStringArray(R.array.emissary_companies)
            val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, fractions)
            binding.autoCompleteTextView.setAdapter(arrayAdapter)
            binding.autoCompleteTextView.isFocusableInTouchMode = false

            when (fraction) {
                RepresentableFractions.UNSELECTED -> {
                    binding.autoCompleteTextView.setText(
                        fractions.get(RepresentableFractions.UNSELECTED.ordinal), false
                    )
                }

                RepresentableFractions.GOLD_HOARDERS -> binding.autoCompleteTextView.setText(
                    fractions.get(RepresentableFractions.GOLD_HOARDERS.ordinal), false
                )

                RepresentableFractions.MERCHANT_ALLIANCE -> binding.autoCompleteTextView.setText(
                    fractions.get(RepresentableFractions.MERCHANT_ALLIANCE.ordinal), false
                )

                RepresentableFractions.ORDER_OF_SOULS -> binding.autoCompleteTextView.setText(
                    fractions.get(RepresentableFractions.ORDER_OF_SOULS.ordinal), false
                )

                RepresentableFractions.ATHENAS_FORTUNE -> binding.autoCompleteTextView.setText(
                    fractions.get(RepresentableFractions.ATHENAS_FORTUNE.ordinal), false
                )

                RepresentableFractions.REAPERS_BONES -> binding.autoCompleteTextView.setText(
                    fractions.get(RepresentableFractions.REAPERS_BONES.ordinal), false
                )

                RepresentableFractions.GUILD -> binding.autoCompleteTextView.setText(
                    fractions.get(RepresentableFractions.GUILD.ordinal), false
                )
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
                    setControlPanelButtonIcon(R.drawable.ic_double_arrow_up)
                    binding.seekBar.isVisible = false
                    binding.autoCompleteTextView.isVisible = false
                }

                ControlPanelState.Opened -> {
                    setControlPanelButtonIcon(R.drawable.ic_double_arrow_down)
                    binding.seekBar.isVisible = true
                    binding.autoCompleteTextView.isVisible = true
                }
            }
        }



        binding.autoCompleteTextView.onItemClickListener =
            object : AdapterView.OnItemClickListener {
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    viewModel.onEvent(Event.ChangeRepresentedFraction(RepresentableFractions.entries[position]))
                }
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

    private fun setControlPanelButtonIcon(drawable: Int) {
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