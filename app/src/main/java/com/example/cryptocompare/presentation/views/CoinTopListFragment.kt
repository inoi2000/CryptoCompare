package com.example.cryptocompare.presentation.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.cryptocompare.databinding.FragmentCoinTopListBinding
import com.example.cryptocompare.presentation.CoinApp
import com.example.cryptocompare.presentation.viewmodels.CoinViewModel
import com.example.cryptocompare.presentation.viewmodels.CoinViewModelFactory
import com.example.cryptocompare.presentation.views.adapters.CoinInfoAdapter
import javax.inject.Inject

class CoinTopListFragment : Fragment() {
    private var _binding: FragmentCoinTopListBinding? = null
    private val binding: FragmentCoinTopListBinding get() = _binding!!

    private val component by lazy {
        (requireActivity().application as CoinApp).component
    }

    @Inject
    lateinit var viewModelFactory: CoinViewModelFactory

    private val viewModel: CoinViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CoinViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        component.inject(this)
        _binding = FragmentCoinTopListBinding.inflate(inflater, container, false)

        val adapter = CoinInfoAdapter(requireContext()) {
            val action =
                CoinTopListFragmentDirections.actionCoinTopListFragmentToCoinInfoFragment(it.name)
            findNavController().navigate(action)
        }
        binding.rvCoinPriceList.itemAnimator = null
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