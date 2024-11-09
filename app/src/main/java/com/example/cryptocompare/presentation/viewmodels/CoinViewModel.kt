package com.example.cryptocompare.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptocompare.domain.entities.CoinInfo
import com.example.cryptocompare.domain.entities.Currency
import com.example.cryptocompare.domain.usecases.GetCoinInfoUseCase
import com.example.cryptocompare.domain.usecases.GetCoinTopListUseCase
import kotlinx.coroutines.launch

class CoinViewModel(
    private val gerCoinInfoListUseCase: GetCoinTopListUseCase,
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
) : ViewModel() {

    private val _priceList = MutableLiveData<List<CoinInfo>>()
    val priceList: LiveData<List<CoinInfo>> get() = _priceList

    private val _coinInfo = MutableLiveData<CoinInfo>()
    val coinInfo: LiveData<CoinInfo> get() = _coinInfo

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _priceList.value = gerCoinInfoListUseCase(Currency.USD, 50)
        }
    }

    fun getDetailInfo(coinName: String, currency: Currency = Currency.USD) {
        viewModelScope.launch {
            _coinInfo.value = getCoinInfoUseCase(currency, coinName)
        }
    }
}