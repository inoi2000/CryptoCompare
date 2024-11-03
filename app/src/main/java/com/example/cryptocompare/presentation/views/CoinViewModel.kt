package com.example.cryptocompare.presentation.views

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptocompare.data.network.ApiFactory
import com.example.cryptocompare.data.database.AppDatabase
import com.example.cryptocompare.data.repositories.CoinRepositoryImpl
import com.example.cryptocompare.domain.entities.CoinInfo
import com.example.cryptocompare.domain.repositories.CoinRepository
import com.example.cryptocompare.domain.usecases.GetCoinInfoListUseCase
import com.example.cryptocompare.domain.usecases.GetCoinPriceUseCase
import com.google.gson.Gson
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val _priceList = MutableLiveData<List<CoinInfo>>()
    val priceList: LiveData<List<CoinInfo>> get() = _priceList

    private val repository: CoinRepository = CoinRepositoryImpl()
    private val gerCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
//    private val getCoinPriceUseCase = GetCoinPriceUseCase(repository)

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _priceList.value = gerCoinInfoListUseCase()
        }
    }
}