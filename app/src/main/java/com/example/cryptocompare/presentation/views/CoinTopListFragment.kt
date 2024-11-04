package com.example.cryptocompare.presentation.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cryptocompare.databinding.FragmentCoinTopListBinding
import com.example.cryptocompare.presentation.views.adapters.CoinInfoAdapter

class CoinTopListFragment : Fragment() {
    private var _binding: FragmentCoinTopListBinding? = null
    private val binding: FragmentCoinTopListBinding get() = _binding!!

    private val viewModel: CoinViewModel by lazy {
        ViewModelProvider(this)[CoinViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinTopListBinding.inflate(inflater, container, false)

        val adapter = CoinInfoAdapter(requireContext()) {
            val action =
                CoinTopListFragmentDirections.actionCoinTopListFragmentToCoinInfoFragment(it.name)
            findNavController().navigate(action)
        }
        binding.rvCoinPriceList.adapter = adapter
        viewModel.priceList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}