package com.example.sot_treasure_tracker.presets.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.databinding.FragmentPresetsBinding
import com.example.sot_treasure_tracker.presets.domain.models.PresetReward
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PresetsFragment : Fragment() {

    private var _binding: FragmentPresetsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PresetsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPresetsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        collectLatestFlow(viewModel.catalog) {
            val adapter = PresetCategoryAdapter(it)
            binding.categoryRecyclerView.adapter = adapter
        }

        binding.applyButton.setOnClickListener {
            val items = viewModel.catalog.value[0].items[0].items
            val bundle = packBundle(items)
            findNavController().navigate(R.id.action_presetsFragment_to_trackerFragment, bundle)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun <T> collectLatestFlow(flow: Flow<T>, collect: suspend (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                flow.collectLatest(collect)
            }
        }
    }

    private fun packBundle(items: List<PresetReward>): Bundle {

        val treasureIds = items.map { it.treasureId }.toIntArray()
        val treasureQuantities = items.map { it.quantity }.toIntArray()

        return bundleOf(
            "treasureIds" to treasureIds,
            "treasureQuantities" to treasureQuantities
        )
    }

}