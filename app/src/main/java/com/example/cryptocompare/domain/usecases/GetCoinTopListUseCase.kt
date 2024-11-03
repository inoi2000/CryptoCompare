package com.example.cryptocompare.domain.usecases

import com.example.cryptocompare.domain.entities.Currency
import com.example.cryptocompare.domain.repositories.CoinRepository

class GetCoinTopListUseCase(private val repository: CoinRepository) {
    suspend operator fun invoke(currency: Currency, limit: Int) =
        repository.getCoinTopList(currency, limit)
}