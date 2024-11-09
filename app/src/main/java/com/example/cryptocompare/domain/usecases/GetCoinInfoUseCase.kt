package com.example.cryptocompare.domain.usecases

import com.example.cryptocompare.domain.entities.Currency
import com.example.cryptocompare.domain.repositories.CoinRepository
import javax.inject.Inject

class GetCoinInfoUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(currency: Currency, coinName: String) =
        repository.getCoinInfo(currency, coinName)
}