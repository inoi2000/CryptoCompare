package com.example.cryptocompare.presentation.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.cryptocompare.databinding.FragmentCoinInfoBinding
import com.example.cryptocompare.presentation.CoinApp
import com.example.cryptocompare.presentation.viewmodels.CoinViewModel
import com.example.cryptocompare.presentation.viewmodels.CoinViewModelFactory
import com.squareup.picasso.Picasso
import javax.inject.Inject

class CoinInfoFragment : Fragment() {
    private var _binding: FragmentCoinInfoBinding? = null
    private val binding: FragmentCoinInfoBinding get() = _binding!!

    private val args by navArgs<CoinInfoFragmentArgs>()

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
        _binding = FragmentCoinInfoBinding.inflate(inflater, container, false)
        viewModel.getDetailInfo(args.coinName)
        viewModel.coinInfo.observe(viewLifecycleOwner) {
            with(binding) {
                tvPrice.text = it.price
                tvMinPrice.text = it.lowDay
                tvMaxPrice.text = it.highDay
                tvLastMarket.text = it.lastMarket
                tvLastUpdate.text = it.lastUpdate
                tvFromSymbol.text = it.name
                tvToSymbol.text = it.comparisonCurrency
                Picasso.get().load(it.imageUrl).into(ivLogoCoin)
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}