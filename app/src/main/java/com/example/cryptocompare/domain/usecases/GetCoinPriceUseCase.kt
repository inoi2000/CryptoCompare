package com.example.cryptocompare.domain.usecases

import com.example.cryptocompare.domain.repositories.CoinRepository

class GetCoinPriceUseCase(private val repository: CoinRepository) {
    suspend operator fun invoke() = repository.getCoinPrice()
}