package com.example.sot_treasure_tracker.calculator.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.calculator.domain.models.EmissaryGrades
import com.example.sot_treasure_tracker.calculator.domain.models.RepresentableFractions
import com.example.sot_treasure_tracker.components.domain.models.TreasureCategory
import com.example.sot_treasure_tracker.components.domain.models.TreasureItem
import com.example.sot_treasure_tracker.calculator.presentation.model.CostValues
import com.example.sot_treasure_tracker.calculator.presentation.model.Event
import com.example.sot_treasure_tracker.databinding.FragmentTrackerBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TrackerFragment : Fragment() {

    private var _binding: FragmentTrackerBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TrackerViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrackerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val menuHost: MenuHost = requireActivity()

        collectLatestFlow(viewModel.catalog) { catalog ->
            if (catalog != null) {
                setupViewPager(catalog.catalog)
                setupTabs()
            }
        }

        collectLatestFlow(viewModel.uiState) { state ->
            setCostValues(state.costValues)
            setFraction(state.representedEmissary)
            setEmissaryGrade(state.emissaryGrade)
            setControlPanelState(state.isControlPanelOpen)
            setLoadingScreen(state.isCatalogLoading)
        }

        binding.autoCompleteTextView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                viewModel.onEvent(
                    Event.ChangeRepresentedFraction(RepresentableFractions.entries[position])
                )
            }

        binding.seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    viewModel.onEvent(Event.ChangeEmissaryGrade(EmissaryGrades.entries[progress]))
                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}

            }
        )

        binding.button.setOnClickListener {
            viewModel.onEvent(Event.ClickControlPanelButton(isOpen = !viewModel.uiState.value.isControlPanelOpen))
        }

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.tracker_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.addPresetMenuItem -> {
                        findNavController().navigate(R.id.action_trackerFragment_to_presetsFragment)
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
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

    private fun setLoadingScreen(isLoading: Boolean) {
        binding.loadingFrameLayout.isVisible = isLoading
        binding.tabLayout.isVisible = !isLoading
        binding.button.isVisible = !isLoading
        binding.controlPanel.isVisible = !isLoading
    }

    private fun setControlPanelState(isOpen: Boolean) {
        binding.seekBar.isVisible = isOpen
        binding.dropDownTextInputLayout.isVisible = isOpen

        if (isOpen)
            setControlPanelButtonIcon(R.drawable.ic_double_arrow_down)
        else
            setControlPanelButtonIcon(R.drawable.ic_double_arrow_up)
    }

    private fun setEmissaryGrade(grade: EmissaryGrades) {
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
        }
    }

    private fun setFraction(fraction: RepresentableFractions) {
        val fractions = resources.getStringArray(R.array.emissary_companies)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, fractions)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)
        binding.autoCompleteTextView.isFocusableInTouchMode = false

        when (fraction) {
            RepresentableFractions.GOLD_HOARDERS -> {
                binding.seekBar.isEnabled = true
                binding.autoCompleteTextView.setText(
                    fractions[RepresentableFractions.GOLD_HOARDERS.ordinal], false
                )
            }

            RepresentableFractions.MERCHANT_ALLIANCE -> {
                binding.seekBar.isEnabled = true
                binding.autoCompleteTextView.setText(
                    fractions[RepresentableFractions.MERCHANT_ALLIANCE.ordinal], false
                )
            }

            RepresentableFractions.ORDER_OF_SOULS -> {
                binding.seekBar.isEnabled = true
                binding.autoCompleteTextView.setText(
                    fractions[RepresentableFractions.ORDER_OF_SOULS.ordinal], false
                )
            }

            RepresentableFractions.ATHENAS_FORTUNE -> {
                binding.seekBar.isEnabled = true
                binding.autoCompleteTextView.setText(
                    fractions[RepresentableFractions.ATHENAS_FORTUNE.ordinal], false
                )
            }

            RepresentableFractions.REAPERS_BONES -> {
                binding.seekBar.isEnabled = true
                binding.autoCompleteTextView.setText(
                    fractions[RepresentableFractions.REAPERS_BONES.ordinal], false
                )
            }

            RepresentableFractions.GUILD -> {
                binding.seekBar.isEnabled = true
                binding.autoCompleteTextView.setText(
                    fractions[RepresentableFractions.GUILD.ordinal], false
                )
            }

            RepresentableFractions.UNSELECTED -> {
                binding.seekBar.isEnabled = false
                binding.autoCompleteTextView.setText(
                    fractions[RepresentableFractions.UNSELECTED.ordinal], false
                )
            }
        }
    }

    private fun setCostValues(costValues: CostValues) {
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
