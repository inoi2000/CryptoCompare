package com.example.cryptocompare.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cryptocompare.domain.usecases.GetCoinInfoUseCase
import com.example.cryptocompare.domain.usecases.GetCoinTopListUseCase
import javax.inject.Inject

class CoinViewModelFactory @Inject constructor(
    private val gerCoinInfoListUseCase: GetCoinTopListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoinViewModel::class.java)) {
            return CoinViewModel(gerCoinInfoListUseCase, getCoinInfoUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}