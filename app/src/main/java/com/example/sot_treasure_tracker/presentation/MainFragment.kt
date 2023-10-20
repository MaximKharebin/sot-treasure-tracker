package com.example.sot_treasure_tracker.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sot_treasure_tracker.R
import com.example.sot_treasure_tracker.data.TreasureStorage
import com.example.sot_treasure_tracker.databinding.FragmentTrackerBinding
import com.example.sot_treasure_tracker.presentation.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    private var _binding: FragmentTrackerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrackerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewPager()
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
}