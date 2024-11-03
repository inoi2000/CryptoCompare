package com.example.cryptocompare.presentation.views

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptocompare.data.repositories.CoinRepositoryImpl
import com.example.cryptocompare.domain.entities.CoinInfo
import com.example.cryptocompare.domain.entities.Currency
import com.example.cryptocompare.domain.repositories.CoinRepository
import com.example.cryptocompare.domain.usecases.GetCoinTopListUseCase
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val _priceList = MutableLiveData<List<CoinInfo>>()
    val priceList: LiveData<List<CoinInfo>> get() = _priceList

    private val repository: CoinRepository = CoinRepositoryImpl()
    private val gerCoinInfoListUseCase = GetCoinTopListUseCase(repository)
//    private val getCoinPriceUseCase = GetCoinPriceUseCase(repository)

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _priceList.value = gerCoinInfoListUseCase(Currency.USD, 50)
        }
    }
}